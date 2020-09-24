package com.lll.student.service;

import com.lll.student.dao.CourseDao;
import com.lll.student.dao.TeachCourseRecordDao;
import com.lll.student.domain.pojo.Course;
import com.lll.student.domain.pojo.TeachCourseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luo
 */
@Service
public class AddNewCourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeachCourseRecordDao teachCourseRecordDao;

    public void insertCourse(Course course) {
        courseDao.insert(course);
    }

    public void insertTeachCourseRecord(TeachCourseRecord teachCourseRecord) {
        teachCourseRecordDao.insert(teachCourseRecord);
    }
}
