package com.lovin.controller;

import com.lovin.pojo.JSONResult;
import com.lovin.pojo.SysUser;
import com.lovin.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;


    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception{
        Sid sid = new Sid();
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lovin");
        user.setNickname("lovin");
        user.setPassword("lovin");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("181113DM9MNGYCX4");
        user.setUsername("lovin-2");
        user.setNickname("lovin-2");
        user.setPassword("lovin-2");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId){
        userService.deleteUser(userId);
        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JSONResult queryUserById(String userId) {
        return JSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JSONResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("lovin");
        user.setNickname("lovin");

        List<SysUser> userList = userService.queryUserList(user);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JSONResult queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }

        int pageSize = 2;

        SysUser user = new SysUser();
//		user.setNickname("lee");

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JSONResult queryUserByIdCustom(String userId) {

        return JSONResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public JSONResult saveUserTransactional() {

        Sid sid = new Sid();
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("fangyw");
        user.setNickname("fangyw");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return JSONResult.ok("保存成功");
    }
}
