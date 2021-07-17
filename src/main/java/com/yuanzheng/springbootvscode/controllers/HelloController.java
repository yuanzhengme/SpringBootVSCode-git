package com.yuanzheng.springbootvscode.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);  // 类文件要使用当前类

    // 测试从配置文件获取值
    @Value("${spring.profiles.active}")
    private String name;

    @GetMapping("/index")
    public String getHello() {
        return "The first program in vscode!";
    }

    @GetMapping("/name")
    public String name() {
        logger.info("test"); // info类型的log信息
        logger.error("slf4j"); // error类型的log信息
        return name;
    }

}