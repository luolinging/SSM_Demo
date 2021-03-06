package com.lll.student.dao;

import com.lll.student.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层由 MyBatis 框架管理
 * 持久层接口
 * @author luo
 */
@Repository
public interface IStudentDao {

    /**
     * 接口方法对应SQL映射文件UserMapper.xml中的id
     *
     * 插入操作
     * @param student 一个学生对象
     */
    @Insert("insert into student(id,name,age,phone,grade_id) values(#{id},#{name},#{age},#{phone},#{grade_id})")
    void insert(Student student);

    /**
     * 删除操作
     * @param id 学生id
     */
    @Delete("delete from student where id = #{id}")
    void delete(Long id);

    /**
     * 修改操作
     * @param student 一个学生对象
     */
    @Update("update student set name = #{name},age = #{age},phone = #{phone},grade_id = #{grade_id} where id = #{id}")
    void update(Student student);

    /**
     * 查询所有student
     * @return 一组student对象
     */
    @Select("select * from student")
    List<Student> findAll();

    /**
     * 根据id查询student
     * @param id 学生id
     * @return 一个student对象
     */
    @Select("select * from student where id=#{id}")
    Student findById(Long id);

    /**
     * 根据name查询一组student（模糊查询）
     * @param name 学生name
     * @return 一组相同name的student对象
     */
    @Select("select * from student where name like CONCAT(CONCAT('%',#{name}),'%')")
    List<Student> findByName(String name);
}
