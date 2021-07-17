package com.yuanzheng.springbootvscode.controllers;

import java.util.Optional;

import com.yuanzheng.springbootvscode.mapper.TeacherMapper;
import com.yuanzheng.springbootvscode.model.Teacher;
import com.yuanzheng.springbootvscode.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TeacherController
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    TeacherRepository teacherReqository;

    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping(value = "/get")
    public ResponseEntity<Object> getAllTeachers() {
        return new ResponseEntity<>(teacherReqository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/mapper/{teacherId}")
    public ResponseEntity<Object> getTeacherById(@PathVariable Integer teacherId) {
        Teacher teacher = teacherMapper.getTeacherById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PutMapping(value = "/save")
    public ResponseEntity<Object> savaOrUpdateTeacherInfo(@RequestBody Teacher teacher) {
        Optional<Teacher> optional = teacherReqository.findById(teacher.getId());

        if (optional.isPresent()) {
            teacherReqository.saveAndFlush(teacher);
            return new ResponseEntity<>("TeacherInfo is flush successfully!", HttpStatus.OK);
        } else {
            teacherReqository.save(teacher);
            return new ResponseEntity<>("TeacherInfo is add successfully!", HttpStatus.OK);
        }
    }

}