package com.lll.student.controller;

import com.lll.student.common.Result;
import com.lll.student.controller.dto.StudentScore;
import com.lll.student.domain.pojo.Score;
import com.lll.student.service.SelectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * @author luo
 * 查询某个学生的某门课程的成绩
 */
@Controller
@Validated
public class SelectScoreController {

    @Autowired
    private SelectScoreService selectScoreService;

    @RequestMapping(value = "selectStudentScore", method = RequestMethod.GET)
    public @ResponseBody Result<StudentScore> selectStudentScore(@NotNull(message = "学生id不能为空") Long studentId, @NotNull(message = "课程id不能为空")Long courseId){
        StudentScore studentScore = selectScoreService.selectStudentScore(studentId, courseId);
        return  Result.wrapSuccessResult(studentScore);
    }
}
