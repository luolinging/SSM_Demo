package com.lll.student.service;

import com.lll.student.dao.StudentDao;
import com.lll.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luo
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> selectAll(){
        return studentDao.selectAll();
    }
}
