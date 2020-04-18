package com.smart.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import  static  org.testng.Assert.*;

public class AnnoAutowireTest {

    public ApplicationContext factory = null;
    private static String[] CONFIG_FILES = { "com/smart/anno/beans.xml" };

    @BeforeMethod
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testAutoByName(){
        Boss boss = (Boss) factory.getBean("boss");
        assertNotNull(boss);
        System.out.println(boss);
    }
}
