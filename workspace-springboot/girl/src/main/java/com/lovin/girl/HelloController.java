package com.lovin.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 第一个SpringBoot程序
 * @Auth lovin
 * @Date 2018/11/07
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    /**
     * http://localhost:8080/hello 或者 http://localhost:8080/hi  都可以访问到此方法
     * method = RequestMethod.GET 如果不写，那么GET 和 POST 两种方式都可以访问到，不过不推荐使用
     * @return
     */
    @RequestMapping(value={"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot!";
    }

    /**
     * http://localhost:8082/girl/cupSize
     * @return
     */
    @RequestMapping(value="/cupSize", method = RequestMethod.GET)
    public String cupSize(){
        return cupSize;
    }

    @RequestMapping(value="/content", method = RequestMethod.GET)
    public String content(){
        return content;
    }

    @RequestMapping(value="/girlPro", method = RequestMethod.GET)
    public String getGirlProperty(){
        return girlProperties.getCupSize();
    }

    /**
     * http://localhost:8081/girl/pathVariable/23  获取url中的id的值
     * @param id
     * @return
     */
    @RequestMapping(value = "/pathVariable/{id}", method = RequestMethod.GET)
    public String pathVariable(@PathVariable("id") Integer id){
        return "pathVariable:"+id;
    }

    /**
     * http://localhost:8081/girl/requestParam?id=111 id不传则为null
     * @param myId  required:是否必传  defaultValue:不传时候取的默认值
     *
     * @return
     * @RequestMapping(value = "/requestParam",method = RequestMethod.GET) 等同于 @GetMapping(value="/requestParam")
     *
     */
    //@RequestMapping(value = "/requestParam",method = RequestMethod.GET)
    @GetMapping(value="/requestParam")
    public String requestParam(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
    //public String requestParam(@RequestParam("id") Integer myId){
        return "RequestParam:"+myId;
    }
}
