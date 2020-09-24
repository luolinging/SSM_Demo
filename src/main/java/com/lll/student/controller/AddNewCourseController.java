package com.lll.student.controller;

import com.google.common.collect.Lists;
import com.lll.student.common.Result;
import com.lll.student.controller.dto.CourseAndTeacherDTO;
import com.lll.student.domain.Student;
import com.lll.student.domain.pojo.Course;
import com.lll.student.domain.pojo.SelectCourseRecord;
import com.lll.student.domain.pojo.TeachCourseRecord;
import com.lll.student.service.AddNewCourseService;
import com.lll.student.service.SelectCourseRecordService;
import com.lll.student.service.StudentService;
import com.lll.student.service.TeachCourseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luo
 * 增加一门新课程 ，并让所有学生都要修这门课程
 */
@Controller
public class AddNewCourseController {

    @Autowired
    private AddNewCourseService addNewCourseService;

    @Autowired
    private TeachCourseRecordService teachCourseRecordService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SelectCourseRecordService selectCourseRecordService;

    @RequestMapping(value = "insertCourse", method = RequestMethod.POST)
    public void insertCourse(Course course){
        addNewCourseService.insertCourse(course);
    }

    @RequestMapping(value = "insertTeachCourseRecord", method = RequestMethod.POST)
    public void insertTeachCourseRecord(TeachCourseRecord teachCourseRecord){
        addNewCourseService.insertTeachCourseRecord(teachCourseRecord);
    }

    @RequestMapping(value = "forceStudentSelectCourse", method = RequestMethod.POST)
    public void forceStudentSelectCourse(Long courseId, List<Long> teacherIdList){
        List<TeachCourseRecord> teachCourseRecordList = teachCourseRecordService.selectByCourseId(courseId);
        for (Long teacherId : teacherIdList) {
            boolean flag = false;
            for (TeachCourseRecord teachCourseRecord : teachCourseRecordList) {
                if(teachCourseRecord.getTeachId().equals(teacherId)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                TeachCourseRecord teachCourseRecord = new TeachCourseRecord();
                teachCourseRecord.setTeachId(teacherId);
                teachCourseRecord.setCourseId(courseId);
                this.insertTeachCourseRecord(teachCourseRecord);
            }
        }
    }

    @RequestMapping(value = "forceStudentSelectCourse1", method = RequestMethod.POST)
    public @ResponseBody Result forceStudentSelectCourse1(@RequestBody CourseAndTeacherDTO courseAndTeacherDTO){
        List<TeachCourseRecord> teachCourseRecordList = Lists.newArrayList();
        List<Long> teacherIdList = courseAndTeacherDTO.getTeacherIdList();
        Long courseId = courseAndTeacherDTO.getCourseId();
        for (Long teacherId : teacherIdList) {
            System.out.println(teacherId);
            List<TeachCourseRecord> teachCourseRecords = teachCourseRecordService.selectByCourseAndTeacher(teacherId, courseId);
            if(CollectionUtils.isEmpty(teachCourseRecords)){
                TeachCourseRecord teachCourseRecord = new TeachCourseRecord();
                teachCourseRecord.setTeachId(teacherId);
                teachCourseRecord.setCourseId(courseId);
                this.insertTeachCourseRecord(teachCourseRecord);
                teachCourseRecordList.add(teachCourseRecord);
            }else {
                teachCourseRecordList.add(teachCourseRecords.get(0));
            }
        }
        List<Student> studentList = studentService.selectAll();
        for (int i = 1; i <= studentList.size(); i++) {
            // 用当前的学生编号 对老师的总个数求余
            int k = i % teachCourseRecordList.size();
            TeachCourseRecord teachCourseRecord = teachCourseRecordList.get(k);
            Student student = studentList.get(i-1);
            SelectCourseRecord selectCourseRecord = new SelectCourseRecord();
            selectCourseRecord.setStudentId(student.getId());
            selectCourseRecord.setTeachCourseRecordId(teachCourseRecord.getId());
            selectCourseRecordService.insert(selectCourseRecord);
        }
        return Result.wrapSuccessResult();
    }

}
