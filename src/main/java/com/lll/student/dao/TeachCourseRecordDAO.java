package com.lll.student.dao;

import com.lll.student.domain.pojo.TeachCourseRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachCourseRecordDAO {

    TeachCourseRecord selectById(Long id);
}
