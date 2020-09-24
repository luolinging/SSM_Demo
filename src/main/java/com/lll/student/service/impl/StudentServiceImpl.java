package com.lll.student.service.impl;

import com.lll.student.common.MyException;
import com.lll.student.dao.IStudentDao;
import com.lll.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层的实现类
 * @author luo
 */
@Service
public class StudentServiceImpl{

    @Autowired
    private IStudentDao studentDao;

    public void insert(Student student) {
        if (student.getGrade_id() > 100){
            throw new MyException("自定义异常");
        }
        studentDao.insert(student);
    }

    public void delete(Long id) {
        studentDao.delete(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        /*int i = 1/0;*/
        return studentDao.findById(id);
    }

    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }
}
