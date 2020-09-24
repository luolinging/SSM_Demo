package com.lll.student.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author luo
 */
@Data
public class CourseAndTeacher {
    private Long courseId;
    private List<Long> teacherIdList;
}
