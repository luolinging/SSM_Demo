package com.lll.student.dao;

import com.lll.student.domain.pojo.SelectCourseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 */
@Repository
public interface SelectCourseRecordDao {
    /**
     * 查询选课记录
     * @param studentId 学生id
     * @return 一组选课记录
     */
    List<SelectCourseRecord> selectCourseRecords(Long studentId);

    /**
     * 增加选课记录
     * @param selectCourseRecord 选课记录
     */
    @Insert("insert into select_course_record(teach_course_record_id,student_id) values(#{teachCourseRecordId},#{studentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    void insert(SelectCourseRecord selectCourseRecord);
}
