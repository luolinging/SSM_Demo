package com.lll.student.controller.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 * @author 
 */
@Data
public class StudentDTO implements Serializable{

    private Long id;

    private String name;

    private Integer age;

    private String phone;

    private Long grade_id;
}