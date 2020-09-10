package com.lll.student.service.impl;

import com.lll.student.dao.IStudentDao;
import com.lll.student.domain.Student;
import com.lll.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层的实现类
 * @author luo
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public List<Student> findAll() {
        System.out.println("service层的findAll.....");
        return studentDao.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }
}
