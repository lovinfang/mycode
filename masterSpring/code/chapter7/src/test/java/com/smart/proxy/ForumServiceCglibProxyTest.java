package com.smart.proxy;

import com.smart.proxy.cglibProxy.CglibProxy;
import com.smart.proxy.cglibProxy.ForumService;
import com.smart.proxy.cglibProxy.ForumServiceImpl;
import org.testng.annotations.Test;

public class ForumServiceCglibProxyTest {

    @Test
    public void cglibProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
