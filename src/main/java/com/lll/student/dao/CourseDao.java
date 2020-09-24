package com.lll.student.dao;

import com.lll.student.domain.pojo.Course;

/**
 * @author luo
 */
public interface CourseDao {
    /**
     * 查找课程
     * @param courseId  课程id
     * @return 一门课程
     */
    Course selectCourseById(Long courseId);

    /**
     * 新增一门课程
     * @param course 课程
     */
    void insert(Course course);
}
