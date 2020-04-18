package com.lovin.rabbitMq.service.busi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/25
 * 创建时间: 16:19
 * 发送短信的服务
 */
@Service
public class SendSms {

    private Logger logger = LoggerFactory.getLogger(SendSms.class);

    public void sendSms(String phoneNumber){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("-------------Already Send Sms to "+phoneNumber);
    }

}
