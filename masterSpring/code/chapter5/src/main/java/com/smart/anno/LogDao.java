package com.smart.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Lazy  //延迟加载
@Repository
public class LogDao implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LogDao....");
    }

    public void saveLog(){}
}
