package com.lll.student;

import com.lll.student.dao.IStudentDao;
import com.lll.student.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testFindAll(){
        try {
            // 加载配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
            // 创建SQLSessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 创建SQLSession对象
            SqlSession sqlSession = factory.openSession();
            // 获取代理类对象
            IStudentDao studentMapper = sqlSession.getMapper(IStudentDao.class);
            // 执行业务
            List<Student> studentList = studentMapper.findAll();
            for (Student student : studentList) {
                System.out.println(student);
            }

            // 关闭资源
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setId(1234567L);
        student.setName("花蝴蝶");
        student.setAge(21);
        student.setPhone("23232242422");
        student.setGradeId(12233L);

        try {
            // 加载配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
            // 创建SQLSessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 创建SQLSession对象
            SqlSession sqlSession = factory.openSession();
            // 获取代理类对象
            IStudentDao studentMapper = sqlSession.getMapper(IStudentDao.class);
            // 执行业务
            studentMapper.insert(student);
            // 提交事务
            sqlSession.commit();
            // 关闭资源
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
