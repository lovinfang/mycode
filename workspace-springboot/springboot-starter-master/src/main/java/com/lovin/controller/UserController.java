package com.lovin.controller;

import com.lovin.pojo.JSONResult;
import com.lovin.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@Controller
@RestController  // @RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
//    @ResponseBody
    public User getUser(){
        User u = new User();
        u.setName("lovin");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("lovin");
        u.setDesc("Hello lovin");
        return u;
    }

    @RequestMapping("/getJsonUser")
//    @ResponseBody
    public JSONResult getJsonUser(){
        User u = new User();
        u.setName("lovin");
        u.setAge(30);
        u.setBirthday(new Date());
        u.setPassword("lovin");
        u.setDesc("Hello lovin");
        return JSONResult.ok(u);
    }
}
