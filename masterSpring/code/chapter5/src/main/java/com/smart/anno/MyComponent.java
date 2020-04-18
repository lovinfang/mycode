package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MyComponent {

    //Spring会将容器中所有类型的Plugin的Bean注入到这个变量中
    @Autowired(required=false)
    private List<Plugin> plugins;

    // 将Plugin类型的Bean注入到Map中
//    @Autowired
//    private Map<String,Plugin> pluginMaps;

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
