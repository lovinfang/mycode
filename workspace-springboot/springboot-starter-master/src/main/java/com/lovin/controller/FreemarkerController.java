package com.lovin.controller;

import com.lovin.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("resource",resource);
        return "freemarker/index";
    }

    /**
     * http://localhost:8088/lovin/ftl/center
     * @return
     */
    @RequestMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }
}
