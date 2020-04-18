package com.lovin.soa.configBean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lovin.soa.registry.BaseRegistry;
import com.lovin.soa.registry.RedisRegistry;

/**
 * 注册中心实体
 * @author lovin
 * @Date 2018/08/05 15:12
 *
 */
public class Registry extends BaseConfigBean implements InitializingBean,ApplicationContextAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3889505056909966086L;

	/**
	 * 注册中心协议
	 */
    private String protocol;

    /**
     * 注册中心地址
     */
    private String address;
    
    public ApplicationContext application;
    
    private static Map<String, BaseRegistry> registryMap = new HashMap<String, BaseRegistry>();
    
    static {
        registryMap.put("redis", new RedisRegistry());
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
	public static Map<String, BaseRegistry> getRegistryMap() {
		return registryMap;
	}

	public static void setRegistryMap(Map<String, BaseRegistry> registryMap) {
		Registry.registryMap = registryMap;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.application = applicationContext;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
