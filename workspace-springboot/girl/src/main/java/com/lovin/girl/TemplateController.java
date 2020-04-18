package com.lovin.girl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 如果要使用Controller 那么就需要在pom中导入 spring-boot-starter-thymeleaf(Spring官方模板)
 *              并新建templates目录，里面新建 index.html文件，这种方式不推荐使用，由于现在已经主流前后端分离
 *
 *              1、使用 @Controller 那么return index 就是返回到 index.html中
 *              2、使用 @Controller 和 @ResponseBody那么return index 就是返回index字符串
 *              3、@RestController = @Controller + @ResponseBody
 *
 *
 * @Auth lovin
 * @Date 2018/11/07
 */
@Controller
@ResponseBody
public class TemplateController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String hello(){
        return "index";
    }
}
