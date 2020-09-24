package com.lll.student.dao;

import com.lll.student.domain.pojo.TeachCourseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 */
@Repository
public interface TeachCourseRecordDao {
    /**
     * 根据id 查询授课记录
     * @param teachCourseId 授课记录id
     * @return 授课记录
     */
    TeachCourseRecord selectTeachCourseRecordById(Long teachCourseId);

    /**
     * 增加授课记录
     * @param teachCourseRecord 授课记录
     */
    @Insert("insert into teach_course_record(teach_id,course_id) values(#{teachId},#{courseId})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    void insert(TeachCourseRecord teachCourseRecord);

    /**
     * 根据课程id查询授课记录
     * @param courseId 课程id
     * @return 一组授课记录
     */
    @Select("select * from teach_course_record where course_id = #{courseId}")
    List<TeachCourseRecord> selectByCourseId(Long courseId);

    @Select("select * from teach_course_record where teach_id = #{teacherId} and course_id = #{courseId}")
    List<TeachCourseRecord> selectByCourseAndTeacher(@Param("teacherId") Long teacherId, @Param("courseId") Long courseId);
}
