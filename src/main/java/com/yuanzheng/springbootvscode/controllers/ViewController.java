package com.yuanzheng.springbootvscode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping(value = "/indexPage")
    public String index(){
        return "index";
    }
}