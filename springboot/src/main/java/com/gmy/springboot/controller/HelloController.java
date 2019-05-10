package com.gmy.springboot.controller;

import com.gmy.springboot.pojo.GmyJSONResult;
import com.gmy.springboot.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello(){
        return "Hello springBoot~~~~";
    }

    @RequestMapping("/getResource")
    public GmyJSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return GmyJSONResult.ok(bean);
    }
}
