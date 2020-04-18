package com.smart.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTest {

    public static void main(String[] args) {
        //使用@Configuration类提供的Bean定义信息启动容器
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
//        LogonService logonService = ctx.getBean(LogonService.class);
//        logonService.printHelllo();

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(DaoConfig.class);
//        ctx.register(ServiceConfig.class);
//        ctx.refresh();
//        LogonService logonService = ctx.getBean(LogonService.class);
//        logonService.printHelllo();

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/conf/beans2.xml");
//        LogonService logonService = ctx.getBean(LogonService.class);
//        System.out.println((logonService.getLogDao() !=null));
//        logonService.printHelllo();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(LogonAppConfig.class);
        LogonService logonService = ctx.getBean(LogonService.class);
        System.out.println((logonService.getLogDao() !=null));
        logonService.printHelllo();

//        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class,ServiceConfig.class);
//        LogonService logonService = ctx.getBean(LogonService.class);
//        System.out.println((logonService.getLogDao() !=null));
//        logonService.printHelllo();

    }
}
