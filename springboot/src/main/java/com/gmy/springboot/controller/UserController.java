package com.gmy.springboot.controller;

import com.gmy.springboot.pojo.GmyJSONResult;
import com.gmy.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController                // @Controller +  @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
//    @ResponseBody
    public User getUser(){
        User u = new User();
        u.setAge(1);
        u.setName("imooc");
        u.setBirthday(new Date());
        u.setPassword("123456");
        return u;
    }

    @RequestMapping("/getUserJson")
//    @ResponseBody
    public GmyJSONResult getUserJson(){

        User u = new User();
        u.setAge(1);
        u.setName("高明阳2");
        u.setBirthday(new Date());
        u.setPassword("123456");
        u.setDesc("月落乌啼霜满天");
        return GmyJSONResult.ok(u);
    }
}
