package com.lll.student.service;

import com.google.common.collect.Lists;
import com.lll.student.common.MyException;
import com.lll.student.common.Result;
import com.lll.student.dao.CourseDao;
import com.lll.student.dao.SelectCourseRecordDao;
import com.lll.student.dao.TeachCourseRecordDao;
import com.lll.student.dao.TeacherDao;
import com.lll.student.domain.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luo
 */
@Service
public class SelectCourseService {
    @Autowired
    private SelectCourseRecordDao selectCourseDao;

    private TeachCourseRecordDao teachCourseRecordDao;

    private CourseDao courseDao;

    private TeacherDao teacherDao;

    //查找选课记录
    public List<SelectCourseResult> selectCourseRecords(Long studentId){
        if(studentId == null){
            throw new MyException("500","参数为空");
        }
        //获取一组选课记录
        List<SelectCourseRecord> selectCourseRecordList = selectCourseDao.selectCourseRecords(studentId);
        //声明一个空的集合  存储  前端显示的内容
        List<SelectCourseResult> selectCourseResultList = Lists.newArrayList();
        //创建一个 前端显示内容的 bean对象
        SelectCourseResult selectCourseResult = new SelectCourseResult();

        for (SelectCourseRecord selectCourseRecord : selectCourseRecordList) {
            //查找授课记录
            TeachCourseRecord teachCourseRecord = teachCourseRecordDao.selectTeachCourseRecordById(selectCourseRecord.getTeachCourseRecordId());
            //查找课程
            Course course = courseDao.selectCourseById(teachCourseRecord.getCourseId());
            //查找老师
            Teacher teacher = teacherDao.selectTeacherById(teachCourseRecord.getTeachId());

            selectCourseResult.setSelectCourseRecordId(selectCourseRecord.getId());
            selectCourseResult.setCourseName(course.getName());
            selectCourseResult.setTeacherName(teacher.getName());
            selectCourseResultList.add(selectCourseResult);
        }
        return selectCourseResultList;
    }
}
