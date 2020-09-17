package com.lll.student.domain.bo;

import lombok.Data;

@Data
public class SelectCourseInfoBO {

    private Long selectCourseRecordId;

    private String courseName;

    private String teacherName;
}
