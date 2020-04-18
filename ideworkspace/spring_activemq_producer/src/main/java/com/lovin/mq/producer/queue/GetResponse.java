package com.lovin.mq.producer.queue;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Destription 接收消费者应答的监听类
 * @Auth lovin
 * @Date 2018/09/10 15:47
 */
@Component
public class GetResponse implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String textMsg = ((TextMessage)message).getText();
            System.out.println("GetResponse accept response : "+textMsg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
