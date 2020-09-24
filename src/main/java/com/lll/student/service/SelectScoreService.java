package com.lll.student.service;

import com.google.common.collect.Lists;
import com.lll.student.common.MyException;
import com.lll.student.controller.dto.StudentScore;
import com.lll.student.dao.*;
import com.lll.student.domain.pojo.SelectCourseRecord;
import com.lll.student.domain.pojo.TeachCourseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luo
 */
@Service
public class SelectScoreService {

    @Autowired
    private TeachCourseRecordDao teachCourseRecordDao;

    @Autowired
    private SelectCourseRecordDao selectCourseRecordDao;

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    public StudentScore selectStudentScore(Long studentId, Long courseId) {
        List<TeachCourseRecord> teachCourseRecordList = teachCourseRecordDao.selectByCourseId(courseId);
        if(teachCourseRecordList.size() <= 0){
            throw new MyException("目前还没有开设该门课程");
        }
        // 授课记录中 有关于该课程的 授课记录，此时用授课记录id 和 学生id 去 选课记录中查询，有没有相关的选课记录
        for (TeachCourseRecord teachCourseRecord : teachCourseRecordList) {
            List<SelectCourseRecord> selectCourseRecordList = selectCourseRecordDao.selectCourseRecords(teachCourseRecord.getId(), studentId);
            if(CollectionUtils.isEmpty(selectCourseRecordList)){
                continue;
            }
            // 选课记录中有相关的 记录，此时用 选课记录id 去 成绩表中查询有没有该id的成绩
            SelectCourseRecord selectCourseRecord = selectCourseRecordList.get(0);
            Double scoreValue = scoreDao.selectBySelectCourseRecordId(selectCourseRecord.getId());
            if(scoreValue == null){
                throw new MyException("该门课的成绩还未录入系统");
            }
            // 拿到了成绩，此时将 学生姓名，课程名，成绩 这三个参数 返回给用户
            StudentScore studentScore = new StudentScore();
            // 1、用学生id 去查询 学生姓名，并塞给返回结果类
            String studentName = studentDao.selectNameById(studentId);
            studentScore.setStudentName(studentName);
            // 2、用课程id 去查询 课程名，并塞给返回的结果类
            String courseName = courseDao.selectNameById(courseId);
            studentScore.setCourseName(courseName);
            studentScore.setScore(scoreValue);
            return studentScore;
        }
        throw new MyException("该生没有选课记录");
    }
}
