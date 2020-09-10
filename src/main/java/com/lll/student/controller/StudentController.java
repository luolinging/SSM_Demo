package com.lll.student.controller;

import com.lll.student.dao.IStudentDao;
import com.lll.student.domain.Student;
import com.lll.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luo
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Student> findAll(){
        // 调用service的方法
        List<Student> studentList = studentService.findAll();
        return studentList;
    }
}
