package com.yuanzheng.springbootvscode.configuration;

import com.yuanzheng.springbootvscode.interceptor.StudentInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorAppConfig implements WebMvcConfigurer {
    @Autowired
    StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry){
        registry.addInterceptor(studentInterceptor);  // 添加拦截器

    }
}