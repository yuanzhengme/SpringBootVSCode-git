package com.yuanzheng.springbootvscode.mapper;

import com.yuanzheng.springbootvscode.model.Teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TeacherMapper
 */
@Mapper
public interface TeacherMapper {

    @Select("SELECT * FROM jpa_teacher WHERE id = #{teacherId}")
    Teacher getTeacherById(@Param("teacherId") Integer teacherId);
}