package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParentContainerBeanTest {

    @Test
    public void testParent() {
        //父容器
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans1.xml"});
        //第二个参数表示 factory的父容器为 pFactory
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans2.xml"},pFactory);
        Boss boss = (Boss)factory.getBean("boss");
        Assert.assertNotNull(boss);
        System.out.println(boss.getCar().toString());
    }
}