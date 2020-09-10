package com.lll.student.service;

import com.lll.student.domain.Student;

import java.util.List;

/**
 * 业务层接口
 * @author luo
 */
public interface IStudentService {
    /**
     * 插入操作
     * @param student 一个学生对象
     */
    void insert(Student student);

    /**
     * 删除操作
     * @param id 学生id
     */
    void delete(Long id);

    /**
     * 修改操作
     * @param student 一个学生对象
     */
    void update(Student student);

    /**
     * 查询所有student
     * @return 一组student对象
     */
    List<Student> findAll();

    /**
     * 根据id查询student
     * @param id 学生id
     * @return 一个student对象
     */
    Student findById(Long id);

    /**
     * 根据name查询一组student（模糊查询）
     * @param name 学生name
     * @return 一组相同name的student对象
     */
    List<Student> findByName(String name);
}
