package com.lll.student.service;

import com.google.common.collect.Lists;
import com.lll.student.dao.TeachCourseRecordDAO;
import com.lll.student.domain.SelectCourseRecord;
import com.lll.student.domain.bo.SelectCourseInfoBO;
import com.lll.student.domain.pojo.Course;
import com.lll.student.domain.pojo.TeachCourseRecord;
import com.lll.student.domain.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCourseBiz {

    @Autowired
    private TeachCourseRecordDAO teachCourseRecordDAO;

    public List<SelectCourseInfoBO> selectCourseInfoList(Long studentId){
        //查询选课记录
        List<SelectCourseInfoBO> selectCourseInfoBOList = Lists.newArrayList();

        List<SelectCourseRecord> selectCourseRecordList = Lists.newArrayList();
        for (SelectCourseRecord selectCourseRecord : selectCourseRecordList) {
            //查授课记录
            TeachCourseRecord teachCourseRecord = teachCourseRecordDAO.selectById(selectCourseRecord.getTeachCourseRecordId());
            //查老师
            //teachCourseRecord.getTeacherId();
            Teacher teacher = new Teacher();
            //查课程
            //teachCourseRecord.getCourseId();
            Course course = new Course();

            SelectCourseInfoBO selectCourseInfoBO = new SelectCourseInfoBO();
            selectCourseInfoBO.setTeacherName(teacher.getName());
            selectCourseInfoBO.setCourseName(course.getName());
            selectCourseInfoBO.setSelectCourseRecordId(selectCourseRecord.getId());
            selectCourseInfoBOList.add(selectCourseInfoBO);
        }
        return selectCourseInfoBOList;
    }
}
