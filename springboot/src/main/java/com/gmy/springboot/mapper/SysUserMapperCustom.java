package com.gmy.springboot.mapper;

import com.gmy.springboot.pojo.SysUser;
import com.gmy.springboot.utils.MyMapper;

import java.util.List;

public interface SysUserMapperCustom extends MyMapper<SysUser> {
    List<SysUser> queryUserSimplyInfoById(String id);
}