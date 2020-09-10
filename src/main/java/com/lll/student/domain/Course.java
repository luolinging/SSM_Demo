package com.lll.student.domain;

import lombok.Data;

/**
 * 课程
 * @author luo
 */
@Data
public class Course {
    private Long id;
    private String name;
    private Integer limitNum;
    private Long teacherId;
}
