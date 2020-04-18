package com.smart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  EnableAutoConfiguration 注解是由Boot提供的，用于对Spring框架进行自动配置
 *  RestController和RequestMapping注解是由Spring MVC提供的
 */
@RestController
@EnableAutoConfiguration
public class BbsDaemon {

    @RequestMapping
    public String index(){
        return "欢迎光临小春论坛！";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(BbsDaemon.class,args);
//    }
}
