package com.lll.student.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SelectCourseInfoDTO implements Serializable {

    private static final long serialVersionUID = -4709683207085474637L;

    private Long selectCourseRecordId;

    private String courseName;

    private String teacherName;
}
