package com.yuanzheng.springbootvscode.controllers.restcontrollers;

import java.util.Arrays;

import com.yuanzheng.springbootvscode.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/os")
public class RestStudentController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/students")
    public String getStudentInfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8089/students", HttpMethod.GET, entity, String.class).getBody();

    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student Student){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8089/students", HttpMethod.POST, entity, String.class).getBody();
    }

}