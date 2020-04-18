package com.lovin.soa.configBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lovin.soa.registry.BaseRegistryDelegate;

public class Service extends BaseConfigBean implements InitializingBean,ApplicationContextAware{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8965645601715957126L;

	private String intf;

    private String ref;

    private String protocol;
    
    private static ApplicationContext application;

    public String getIntf() {
        return intf;
    }

    public void setIntf(String intf) {
        this.intf = intf;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * spring启动的过程中，将注册到redis服务的服务委托给BaseRegistryDelegate进行实现
     * 委托者模式
     */
	public void afterPropertiesSet() throws Exception {
		BaseRegistryDelegate.registry(ref, application);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Service.application = applicationContext;
	}
	
	public static ApplicationContext getApplication() {
        return application;
    }
}
