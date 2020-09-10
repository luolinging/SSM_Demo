package com.lll.student.domain;

import lombok.Data;

/**
 * @author luo
 */
@Data
public class SelectCourseRecord {
    private Long id;
    private Long studentId;
    private Long courseId;
}
