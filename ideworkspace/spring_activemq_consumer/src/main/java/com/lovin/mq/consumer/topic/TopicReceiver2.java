package com.lovin.mq.consumer.topic;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Destription Topic消息监听器
 * @Auth lovin
 * @Date 2018/09/08 21:44
 */
@Component
public class TopicReceiver2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String textMsg = ((TextMessage)message).getText();
            System.out.println("TopicReceiver2 accept msg : "+textMsg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
