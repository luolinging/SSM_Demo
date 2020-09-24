package com.lll.student.controller;

import com.alibaba.fastjson.JSON;
import com.lll.student.common.MyException;
import com.lll.student.common.Result;
import com.lll.student.domain.pojo.SelectCourseResult;
import com.lll.student.service.SelectCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author luo
 */
@Controller
@Slf4j
@Validated
public class SelectCourseResultController {
    @Autowired
    private SelectCourseService selectCourseService;

    @RequestMapping(value = "selectCourseRecords",method = RequestMethod.GET)
    public @ResponseBody Result<List<SelectCourseResult>> selectCourseRecords(@NotNull(message = "学生id为空") Long studentId){
        log.info("查询选课记录，studentId:{}", studentId);
        List<SelectCourseResult> selectCourseResultList = selectCourseService.selectCourseRecords(studentId);
        log.info("查询选课记录结果，selectCourseResults：{}", JSON.toJSONString(selectCourseResultList));
        return Result.wrapSuccessResult(selectCourseResultList);
    }
}
