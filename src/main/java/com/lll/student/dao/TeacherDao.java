package com.lll.student.dao;

import com.lll.student.domain.pojo.Course;
import com.lll.student.domain.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

/**
 * @author luo
 */
public interface TeacherDao {

    /**
     * 根据老师id查询老师
     * @param teacherId 老师id
     * @return 一位老师
     */
    @Select("select * from teacher where id = #{id}")
    Teacher selectTeacherById(Long teacherId);
}
