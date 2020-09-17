package com.lll.student.controller;

import com.google.common.collect.Lists;
import com.lll.student.domain.bo.SelectCourseInfoBO;
import com.lll.student.domain.dto.SelectCourseInfoDTO;
import com.lll.student.service.SelectCourseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SelectCourseController {

    @Autowired
    private SelectCourseBiz selectCourseBiz;

    public List<SelectCourseInfoDTO> selectCourseInfoList(Long studentId){
        List<SelectCourseInfoBO> selectCourseInfo = selectCourseBiz.selectCourseInfoList(studentId);
        List<SelectCourseInfoDTO> selectRecordList = Lists.newArrayList();
        for (SelectCourseInfoBO selectCourseInfoBO : selectCourseInfo) {
            SelectCourseInfoDTO selectCourseInfoDTO = new SelectCourseInfoDTO();
            selectCourseInfoDTO.setTeacherName(selectCourseInfoBO.getTeacherName());
            selectCourseInfoDTO.setCourseName(selectCourseInfoBO.getCourseName());
            selectCourseInfoDTO.setSelectCourseRecordId(selectCourseInfoBO.getSelectCourseRecordId());
            selectRecordList.add(selectCourseInfoDTO);
        }
        return selectRecordList;
    }
}
