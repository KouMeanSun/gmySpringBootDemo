package com.gmy.springboot.config;

import com.gmy.springboot.interceptor.OneInterceptor;
import com.gmy.springboot.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                                                     .addPathPatterns("/one/**");
    }
}
