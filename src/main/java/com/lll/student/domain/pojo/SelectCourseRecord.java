package com.lll.student.domain.pojo;

import lombok.Data;

@Data
public class SelectCourseRecord {

    private Long id;

    private Long studentId;

    private Long teachCourseRecordId;
}
