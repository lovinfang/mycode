package com.lovin.soa.spring.parse;

import com.lovin.soa.configBean.Protocol;
import com.lovin.soa.configBean.Reference;
import com.lovin.soa.configBean.Registry;
import com.lovin.soa.configBean.Service;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SOANamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("registry",
                new RegistryBeanDefinitionParse(Registry.class));
        registerBeanDefinitionParser("protocol",
                new ProtocolBeanDefinitionParse(Protocol.class));
        registerBeanDefinitionParser("reference",
                new ReferenceBeanDifinitionParse(Reference.class));
        registerBeanDefinitionParser("service",
                new ServiceBeanDefinitionParse(Service.class));
    }
}
