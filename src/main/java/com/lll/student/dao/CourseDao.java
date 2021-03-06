package com.lll.student.dao;

import com.lll.student.domain.pojo.Course;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author luo
 */
public interface CourseDao {

    /**
     * 根据课程id查询课程名
     * @param courseId
     * @return
     */
    @Select("select name from course where id = #{courseId}")
    String selectNameById(Long courseId);

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
    @Select("insert into course(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    void insert(Course course);
}
