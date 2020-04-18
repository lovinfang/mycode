package com.lovin.rabbitMq.controller;


import com.lovin.rabbitMq.service.IUserReg;
import com.lovin.rabbitMq.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller
 */
@Controller
public class UserRegController {

    private static final String SUCCESS = "suc";
    private static final String FAILUER = "failure";

    @Autowired
    @Qualifier("async")
    private IUserReg userReg;

    @RequestMapping("/userReg")
    public String userReg(){
        return "index";
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(@RequestParam("userName")String userName,
                           @RequestParam("email")String email,
                           @RequestParam("phoneNumber")String phoneNumber){
        try {
            if (userReg.userRegister(User.makeUser(userName,email,phoneNumber)))
                return SUCCESS;
            else
                return FAILUER;
        } catch (Exception e) {
            return FAILUER;
        }
    }


}
