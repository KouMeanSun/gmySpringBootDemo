package com.gmy.springboot.controller;

import com.gmy.springboot.pojo.GmyJSONResult;
import com.gmy.springboot.pojo.SysUser;
import com.gmy.springboot.pojo.User;
import com.gmy.springboot.utils.JSONUtils;
import com.gmy.springboot.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator  redis;

    @RequestMapping("/test")
    public GmyJSONResult test(){
        SysUser user = new SysUser();
        user.setId("1001");
        user.setUsername("test");
        user.setNickname("lee123");
        strRedis.opsForValue().set("json:user",JSONUtils.objectToJson(user));

        SysUser jsonUser = JSONUtils.jsonToPojo(strRedis.opsForValue().get("json:user"),SysUser.class);
        return  GmyJSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public GmyJSONResult getJsonList(){
        User u = new User();
        u.setAge(1);
        u.setName("imooc");
        u.setBirthday(new Date());
        u.setPassword("123456");

        User u2 = new User();
        u2.setAge(10);
        u2.setName("gaomingyang");
        u2.setBirthday(new Date());
        u2.setPassword("123456");

        User u3 = new User();
        u3.setAge(10);
        u3.setName("zhaona");
        u3.setBirthday(new Date());
        u3.setPassword("123456");

        List<User>  userList = new ArrayList<User>();
        userList.add(u);
        userList.add(u2);
        userList.add(u3);

        redis.set("json:info:userlist",JSONUtils.objectToJson(userList),2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JSONUtils.jsonToList(userListJson,User.class);

        return GmyJSONResult.ok(userListBorn);
    }
}
