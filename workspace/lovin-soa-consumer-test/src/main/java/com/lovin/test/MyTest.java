package com.lovin.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
    	//加载Spring配置上下文
        ApplicationContext app = new ClassPathXmlApplicationContext("consumer.xml");
        
        UserService user = app.getBean(UserService.class);
        user.eat("");
    }
}
