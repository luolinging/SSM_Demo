package com.lll.student.domain;

import lombok.Builder;
import lombok.Data;

/**
 * 学院
 * @author luo
 */
@Data
@Builder
public class College {
    private Long id;
    private String name;
}
