package com.yuanzheng.springbootvscode.controllers;

import java.util.HashMap;
import java.util.Map;

import com.yuanzheng.springbootvscode.exception.StudentNotFoundException;
import com.yuanzheng.springbootvscode.model.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("/students")
public class StudentController {
    private static Map<String, Student> studentRepo = new HashMap<>();
    static {
        Student s = new Student();
        s.setId("1");
        s.setName("Lily");
        s.setAge("22");
        s.setSubject("English");
        studentRepo.put(s.getId(), s);

        Student s2 = new Student();
        s2.setId("2");
        s2.setName("Jack");
        s2.setAge("21");
        s2.setSubject("Chia");
        studentRepo.put(s2.getId(), s2);
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(studentRepo.values(), HttpStatus.OK);
    }

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable("studentId") String studentId) {
        return new ResponseEntity<>(studentRepo.get(studentId), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        studentRepo.put(student.getId(), student);
        return new ResponseEntity<>("Add a Student succeed!", HttpStatus.CREATED);
    }

    // PutMapping和PostMapping和GetMapping的路径可以是一样的，通过请求类型不同来区分调用哪个方法
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable String id, @RequestBody Student student) {
        if (!studentRepo.containsKey(id)) {
            throw new StudentNotFoundException();
        }
        studentRepo.remove(id);
        student.setId(id);
        studentRepo.put(id, student);
        return new ResponseEntity<>("Update one Student succeed!", HttpStatus.OK);

    }

    // 删除方法可以使用post或put但是使用delete更名正言顺
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteStudentById(@PathVariable String id) {
        studentRepo.remove(id);
        return new ResponseEntity<>("Delete id is:" + id + "Student successfully!", HttpStatus.OK);
    }
}