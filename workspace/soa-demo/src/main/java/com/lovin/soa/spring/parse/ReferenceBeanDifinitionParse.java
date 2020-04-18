package com.lovin.soa.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @Description ReferenceB标签的解析类
 * @ClassName   ReferenceBeanDifinitionParse
 * @Date        2018年7月22日 下午19:36:12
 * @Author      lovin
 */
public class ReferenceBeanDifinitionParse implements BeanDefinitionParser {

    private Class<?> beanClass;

    public ReferenceBeanDifinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        //spring会把这个beanClass进行实例化  BeanDefinitionNames??
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        String id = element.getAttribute("id");
        String intf = element.getAttribute("interface");
        String protocol = element.getAttribute("protocol");
        String loadbalance = element.getAttribute("loadbalance");
        String cluster = element.getAttribute("cluster");
        String retries = element.getAttribute("retries");  //可以设置默认值

        if (id == null || "".equals(id)) {
            throw new RuntimeException("Reference id 不能为空！");
        }
        if (intf == null || "".equals(intf)) {
            throw new RuntimeException("Reference interface 不能为空！");
        }
        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("Reference protocol 不能为空！");
        }
        if (loadbalance == null || "".equals(loadbalance)) {
            throw new RuntimeException("Reference loadbalance 不能为空！");
        }

        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("intf", intf);
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        beanDefinition.getPropertyValues().addPropertyValue("loadbalance", loadbalance);
        beanDefinition.getPropertyValues().addPropertyValue("retries", retries);
        beanDefinition.getPropertyValues().addPropertyValue("cluster", cluster);
        //注册进Spring容器中
        parserContext.getRegistry().registerBeanDefinition("Reference" + id, beanDefinition);
        return beanDefinition;
    }
}
