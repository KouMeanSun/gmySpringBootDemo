package com.gmy.springboot.controller;

import com.gmy.springboot.pojo.GmyJSONResult;
import com.gmy.springboot.pojo.SysUser;
import com.gmy.springboot.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public GmyJSONResult saveUser() throws Exception{
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("gaomingyang"+new Date());
        user.setNickname("gaomingyang"+new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return GmyJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public GmyJSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("190428BK256HD9GC");
        user.setUsername("高明阳");
        user.setNickname("一等肃毅侯");
        user.setPassword("123456");

        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return GmyJSONResult.ok("保存成功！");
    }

    @RequestMapping("/deleteUser")
    public GmyJSONResult deleteUser(String userId){
        userService.deleteUser(userId);
        return GmyJSONResult.ok("删除成功！");
    }

    @RequestMapping("/queryUserById")
    public GmyJSONResult queryUserById(String userId){
        return GmyJSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public GmyJSONResult queryUserList(){
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setNickname("lee123");

        List<SysUser> userList = userService.queryUserList(user);
        return GmyJSONResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public GmyJSONResult queryUserListPaged(Integer page){
        if (page == null){
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user,page,pageSize);
        return GmyJSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public GmyJSONResult queryUserByIdCustom(String userId){
        return GmyJSONResult.ok(userService.queryUserByIdCustom(userId));
    }
}
