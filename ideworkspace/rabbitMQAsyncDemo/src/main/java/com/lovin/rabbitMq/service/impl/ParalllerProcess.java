package com.lovin.rabbitMq.service.impl;

import com.lovin.rabbitMq.service.IUserReg;
import com.lovin.rabbitMq.service.busi.SaveUser;
import com.lovin.rabbitMq.service.busi.SendEmail;
import com.lovin.rabbitMq.service.busi.SendSms;
import com.lovin.rabbitMq.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/07
 * 创建时间: 21:58
 * 并发模式
 */
@Service
@Qualifier("para")
public class ParalllerProcess implements IUserReg {

    private static Logger logger = LoggerFactory.getLogger(ParalllerProcess.class);

    @Autowired
    private SaveUser saveUser;
    @Autowired
    private SendEmail sendEmail;
    @Autowired
    private SendSms sendSms;

    //发送邮件的线程
    private static class SendEmailThread implements Callable<Boolean>{

        private SendEmail sendEmail;
        private String email;

        public SendEmailThread(SendEmail sendEmail, String email) {
            this.sendEmail = sendEmail;
            this.email = email;
        }

        public Boolean call() throws Exception {
            sendEmail.sendEmail(email);
            logger.info("SendEmailThread send mail to"+email);
            return true;
        }
    }

    //发送短信的线程
    private static class SendSmsThread implements Callable<Boolean>{

        private SendSms sendSms;
        private String phoneNumber;

        public SendSmsThread(SendSms sendSms, String phoneNumber) {
            this.sendSms = sendSms;
            this.phoneNumber = phoneNumber;
        }

        public Boolean call() throws Exception {
            sendSms.sendSms(phoneNumber);
            logger.info("SendSmsThread send mail to"+phoneNumber);
            return true;
        }
    }

    public boolean userRegister(User user) {
        FutureTask<Boolean> sendEmailFuture =
                new FutureTask<Boolean>(new SendEmailThread(sendEmail,user.getEmail()));
        FutureTask<Boolean> sendSmsFuture =
                new FutureTask<Boolean>(new SendSmsThread(sendSms,user.getPhoneNumber()));
        try {
            saveUser.saveUser(user);
            new Thread(sendEmailFuture).start();
            new Thread(sendSmsFuture).start();
            sendEmailFuture.get();//获取邮件发送的结果
            sendSmsFuture.get();//获取短信发送的结果
            return true;
        } catch (Exception e) {
            logger.error(e.toString());
            return  false;
        }

    }
}
