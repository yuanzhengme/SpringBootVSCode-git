package com.yuanzheng.springbootvscode.controllers.exceptioncontrollers;

import com.yuanzheng.springbootvscode.exception.StudentNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionController {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> studentException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student not fount!", HttpStatus.NOT_FOUND);  //404 BAD_REQUEST400
    }
}