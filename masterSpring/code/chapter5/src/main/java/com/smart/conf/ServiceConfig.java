package com.smart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    //像普通Bean一样注入DaoConfig
    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService(){
        LogonService logonService = new LogonService();
        System.out.println(daoConfig.logDao() == daoConfig.logDao());
        //像普通Bean一样，调用Bean 相关的方法
        logonService.setLogDao(daoConfig.logDao());
        logonService.setUserDao(daoConfig.userDao());
        return logonService;
    }
}
