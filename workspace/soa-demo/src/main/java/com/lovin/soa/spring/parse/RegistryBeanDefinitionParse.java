package com.lovin.soa.spring.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @Description Registry标签的解析类
 * @ClassName   RegistryBeanDefinitionParse
 * @Date        2018年7月22日 下午18:32:12
 * @Author      lovin
 */
public class RegistryBeanDefinitionParse implements BeanDefinitionParser {

    //Regitry
    private Class<?> beanClass;

    public RegistryBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        //spring会把这个beanClass进行实例化  BeanDefinitionNames??
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false); //设置懒加载为false
        String protocol = element.getAttribute("protocol");
        String address = element.getAttribute("address");

        if (protocol == null || "".equals(protocol)) {
            throw new RuntimeException("Regitry protocol 不能为空！");
        }
        if (address == null || "".equals(address)) {
            throw new RuntimeException("Regitry address 不能为空！");
        }

        //添加属性
        beanDefinition.getPropertyValues().addPropertyValue("protocol", protocol);
        beanDefinition.getPropertyValues().addPropertyValue("address", address);
        parserContext.getRegistry().registerBeanDefinition("Registry" + address, beanDefinition);
        return beanDefinition;
    }
}
