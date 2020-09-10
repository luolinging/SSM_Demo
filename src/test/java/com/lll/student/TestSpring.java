package com.lll.student;

import com.lll.student.service.IStudentService;
import com.lll.student.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test //测试spring的环境是否正常
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        IStudentService studentService = applicationContext.getBean("studentService", StudentServiceImpl.class);
        studentService.findAll();
    }
}
