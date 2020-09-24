package com.lll.student.service;

import com.lll.student.dao.TeachCourseRecordDao;
import com.lll.student.domain.pojo.TeachCourseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luo
 */
@Service
public class TeachCourseRecordService {

    @Autowired
    private TeachCourseRecordDao teachCourseRecordDao;

    public List<TeachCourseRecord> selectByCourseId(Long courseId) {
        return teachCourseRecordDao.selectByCourseId(courseId);
    }

    public List<TeachCourseRecord> selectByCourseAndTeacher(Long teacherId, Long courseId) {
        return teachCourseRecordDao.selectByCourseAndTeacher(teacherId, courseId);
    }
}
