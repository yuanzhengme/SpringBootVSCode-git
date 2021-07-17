package com.yuanzheng.springbootvscode.repository;

import com.yuanzheng.springbootvscode.model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeacherRepository
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    
}