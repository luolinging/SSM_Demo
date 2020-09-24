package com.lll.student.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author luo
 * DTO 要进行序列化，方便网络中的传输
 */
@Data
public class CourseAndTeacherDTO implements Serializable {
    private static final long serialVersionUID = -596668932026414547L;
    private Long courseId;
    private List<Long> teacherIdList;
}
