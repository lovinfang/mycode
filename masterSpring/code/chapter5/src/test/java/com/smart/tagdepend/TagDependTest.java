package com.smart.tagdepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TagDependTest {

    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = { "com/smart/tagdepend/beans.xml" };

    @BeforeMethod
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testInheritTag(){
        Car car1 = (Car)factory.getBean("car1");
        Car car2 = (Car)factory.getBean("car2");
        Assert.assertNotNull(car1);
        Assert.assertNotNull(car2);
    }

    @Test
    public void testCacheTask(){
        CacheManager cacheManager = (CacheManager) factory.getBean("cacheManager");
    }

    @Test
    public void testReferenceTag(){
        Boss boss = (Boss)factory.getBean("boss");
        Assert.assertNotNull(boss);
        System.out.println(boss);
    }
}
