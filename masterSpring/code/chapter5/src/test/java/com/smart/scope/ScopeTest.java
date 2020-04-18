package com.smart.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration("classpath*:/com/smart/scope/beans.xml")
public class ScopeTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("boss1")
    private Boss boss1;

    @Autowired
    @Qualifier("boss2")
    private Boss boss2;

    @Autowired
    @Qualifier("boss3")
    private Boss boss3;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testInject() {
        Assert.assertNotSame(boss1.getCar(), boss2.getCar());
        Assert.assertNotSame(boss2.getCar(), boss3.getCar());
    }
}
