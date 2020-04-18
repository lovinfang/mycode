package com.lovin.soa.registry;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.lovin.soa.configBean.Registry;

/**
 * 委托者模式，将注册redis服务的方法委托给BaseRegistryDelegate处理
 * @author Administrator
 *
 */
public class BaseRegistryDelegate {
	public static void registry(String ref, ApplicationContext application) {
		// <lovin:registry protocol="redis" address="127.0.0.1:6379"></lovin:registry> 
		// 拿到注册中心的配置信息，可以多个,此时使用策略模式
		Registry registry = application.getBean(Registry.class);
		String protocol = registry.getProtocol();
		BaseRegistry registryBean = registry.getRegistryMap().get(protocol);
		registryBean.registry(ref, application);
	}
	
	public static List<String> getRegistry(String id,ApplicationContext application) {
        Registry registry = application.getBean(Registry.class);
        String protocol = registry.getProtocol();
        BaseRegistry registryBean = registry.getRegistryMap().get(protocol);
        
        return registryBean.getRegistry(id, application);
    }
}
