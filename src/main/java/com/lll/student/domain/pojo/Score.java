package com.lll.student.domain.pojo;

import lombok.Data;

/**
 * @author luo
 */
@Data
public class Score {
    private Long id;
    private Long selectCourseRecordId;
    private Double score;
}
