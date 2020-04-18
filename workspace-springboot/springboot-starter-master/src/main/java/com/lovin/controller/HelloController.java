package com.lovin.controller;

import com.lovin.pojo.JSONResult;
import com.lovin.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello Spring-Boot";
    }

    @RequestMapping("/getResource")
    public JSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JSONResult.ok(bean);
    }
}
