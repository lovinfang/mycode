package com.lovin.soa.configBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.lovin.soa.netty.NettyUtil;
import com.lovin.soa.rmi.RmiUtil;

/**
 *
 * @Description 轮询的负载均衡算法 
 * @ClassName   RoundRobinLoadBalance 
 * @Date        2018年08月11日 下午7:45:41 
 * @Author      lovin
 *
 * ApplicationListener<ContextRefreshedEvent>  Spring启动成功之后注册的事件
 */
public class Protocol extends BaseConfigBean implements InitializingBean,
								ApplicationContextAware,ApplicationListener<ContextRefreshedEvent>{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8496308724797173048L;

	private String name;

    private String port;

    private String host;
    
    private String contextpath;
    
    private static ApplicationContext application;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    public String getContextpath() {
        return contextpath;
    }
    
    public void setContextpath(String contextpath) {
        this.contextpath = contextpath;
    }
    
    public static ApplicationContext getApplication() {
        return application;
    }

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Protocol.application = applicationContext;
	}

	public void afterPropertiesSet() throws Exception {
		if (name.equalsIgnoreCase("rmi")) {
			//启动RMI协议的服务
            RmiUtil rmi = new RmiUtil();
            rmi.startRmiServer(host, port, "lovinsoarmi");
        }
		
//		else if(name.equalsIgnoreCase("netty")){  //这样去注册netty是有问题的
//        	try {
//				NettyUtil.startServer(port);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//        }
	}

	/**
	 * ContextRefreshedEvent这个事件是spring启动完成以后触发的事件
	 * 我们在成功启动Spring之后再去启动netty
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (!ContextRefreshedEvent.class.getName().equals(event.getClass()
                .getName())) {
            return;
        }
        
        if (!"netty".equalsIgnoreCase(name)) {
            return;
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    NettyUtil.startServer(port);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }).start();
	}
}
