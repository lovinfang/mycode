package com.smart.proxy;

import com.smart.proxy.jdkProxy.PerformaceHandler;
import com.smart.proxy.nomal.ForumService;
import com.smart.proxy.nomal.ForumServiceImpl;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceNomalTest {

    @Test
    public void proxy(){
        // 业务类正常编码的测试
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

    @Test
    public void jdkProxy(){
        //希望被代理的目标业务类，将目标业务类和横切代码编织到一起
        ForumService target = new ForumServiceImpl();
        PerformaceHandler handler = new PerformaceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
