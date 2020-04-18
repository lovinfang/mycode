package com.smart.anno;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LogonService implements BeanNameAware {

    @Lazy
    @Autowired(required=false)
    private LogDao logDao;

    //注入名为 userDao、类型为UserDao的Bean
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void saveLog(){
        logDao.saveLog();
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName:" + beanName);
    }
/*
    // 自动将名为 userDao的Bean传给方法入参
    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        System.out.println("auto inject");
        this.userDao = userDao;
    }


    // 自动将 LogDao传给方法入参
    @Autowired
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }*/

    /*
        @Autowired
        public void init(@Qualifier("userDao")UserDao userDao,LogDao logDao){
            System.out.println("multi param inject");
            this.userDao = userDao;
            this.logDao =logDao;
        }*/

    public void initMethod1() {
        System.out.println("initMethod1");
    }

    public void initMethod2() {
        System.out.println("initMethod2");
    }

}
