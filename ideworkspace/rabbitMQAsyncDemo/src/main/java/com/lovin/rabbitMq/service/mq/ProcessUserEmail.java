package com.lovin.rabbitMq.service.mq;

import com.lovin.rabbitMq.service.busi.SendEmail;
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
 * 消息消费端监听邮件消息类
 */
@Component
public class ProcessUserEmail implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(ProcessUserEmail.class);

    @Autowired
    private SendEmail sendEmail;

    public void onMessage(Message message) {
        logger.info("accept message,ready process......");
        sendEmail.sendEmail(new String(message.getBody()));

    }
}
