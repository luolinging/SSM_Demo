package com.lll.student.domain.pojo;

import lombok.Data;

/**
 * @author luo
 */
@Data
public class SelectCourseRecord {
    private Long id;
    private Long teachCourseRecordId;
    private Long studentId;
}
