package com.lovin.mq.consumer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Destription 队列消息监听器
 * @Auth lovin
 * @Date 2018/09/08 21:41
 */

@Component
public class QueueReceiver1 implements MessageListener {

    @Autowired
    private ReplyTo replyTo;

    @Override
    public void onMessage(Message message) {
        try {
            String textMsg = ((TextMessage)message).getText();
            System.out.println("QueueReceiver1 accept msg : "+textMsg);
            //do my 业务工作
            replyTo.send(textMsg,message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
