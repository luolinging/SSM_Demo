package com.lll.student.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable{
    private Long id;

    private String name;

    private Integer age;

    private String phone;

    private Long gradeId;
}