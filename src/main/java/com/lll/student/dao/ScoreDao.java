package com.lll.student.dao;

import com.lll.student.domain.pojo.Score;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author luo
 */
@Repository
public interface ScoreDao {

    /**
     *
     * @param selectCourseRecordId 选课记录id
     * @return 成绩
     */
    @Select("select score from score where select_course_record_id = #{selectCourseRecordId}")
    Double selectBySelectCourseRecordId(Long selectCourseRecordId);
}
