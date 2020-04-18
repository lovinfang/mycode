package com.lovin.rabbitMq.service.mq;

import com.lovin.rabbitMq.service.busi.SendSms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/07
 * 创建时间: 21:49
 * 消息消费端监听sms消息类
 */
@Component
public class ProcessUserSms implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(ProcessUserSms.class);

    @Autowired
    private SendSms sendSms;

    public void onMessage(Message message) {
        logger.info("accept message,ready process......");
        sendSms.sendSms(new String(message.getBody()));

    }
}
