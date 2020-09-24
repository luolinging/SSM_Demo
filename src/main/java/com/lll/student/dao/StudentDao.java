package com.lll.student.dao;

import com.lll.student.domain.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 */
@Repository
public interface StudentDao {

    @Select("select * from student")
    List<Student> selectAll();

    @Select("select name from student where id = #{studentId}")
    String selectNameById(Long studentId);
}
