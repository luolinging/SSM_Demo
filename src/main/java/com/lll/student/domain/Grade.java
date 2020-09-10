package com.lll.student.domain;

import lombok.Data;

/**
 * 年级 / 班级
 * @author luo
 */
@Data
public class Grade {
    private Long id;
    private Integer gradeAge;
    private Integer gradeNum;
    private Long departmentId;
}
