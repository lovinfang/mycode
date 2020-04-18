package com.smart.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //将一个POJO标注为定义Bean的配置类
public class AppConf {

    @Bean //将以下两个方法定义了两个Bean，并提供了Bean的实例化逻辑
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public LogDao logDao(){
        return new LogDao();
    }

    @Bean //定义logonService 的Bean
    public LogonService logonService(){
        LogonService logonService = new LogonService();
        //将 UserDao LogDao 定义的Bean注入到logonService中
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());
        return logonService;
    }
}
