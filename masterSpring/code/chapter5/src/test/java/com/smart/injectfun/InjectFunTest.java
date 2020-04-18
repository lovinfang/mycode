package com.smart.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InjectFunTest {

    public ApplicationContext factory = null;

    private static String[] CONFIG_FILES = { "com/smart/injectfun/beans.xml" };

    @BeforeMethod
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testLookup(){
        MagicBoss mboss = (MagicBoss) factory.getBean("magicBoss");
        Assert.assertNotSame(mboss.getCar(),mboss.getCar());
    }

    @Test
    public void testReplace(){
        MagicBoss mboss = (MagicBoss) factory.getBean("boss1");
        assertEquals(mboss.getCar().getBrand(),"美人豹");
    }
}
