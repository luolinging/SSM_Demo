package com.lll.student.domain.pojo;

import lombok.Data;

/**
 * 前端在页面上要展示的内容
 * 不是数据库中真实存在的表
 * @author luo
 */
@Data
public class SelectCourseResult {
    private Long selectCourseRecordId;
    private String courseName;
    private String teacherName;
}
