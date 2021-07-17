package com.yuanzheng.springbootvscode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LocaleController {
    @RequestMapping(value="/locale")
    public String getLocalPage() {
        return "locale";
    }
    
}