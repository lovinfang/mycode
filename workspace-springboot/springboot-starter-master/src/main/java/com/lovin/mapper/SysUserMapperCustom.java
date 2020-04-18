package com.lovin.mapper;

import com.lovin.pojo.SysUser;

import java.util.List;


public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}