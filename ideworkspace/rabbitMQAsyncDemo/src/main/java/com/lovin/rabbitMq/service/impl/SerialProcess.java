package com.lovin.rabbitMq.service.impl;

import com.lovin.rabbitMq.service.IUserReg;
import com.lovin.rabbitMq.service.busi.SaveUser;
import com.lovin.rabbitMq.service.busi.SendEmail;
import com.lovin.rabbitMq.service.busi.SendSms;
import com.lovin.rabbitMq.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/25
 * 创建时间: 16:28
 * 串行的用户注册
 */
@Service
@Qualifier("serial")
public class SerialProcess implements IUserReg {

    @Autowired
    private SaveUser saveUser;
    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private SendSms sendSms;

    public boolean userRegister(User user) {
        try {
            saveUser.saveUser(user);
            sendEmail.sendEmail(user.getEmail());
            sendSms.sendSms(user.getPhoneNumber());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
