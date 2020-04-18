package com.lovin.mq.consumer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Destription 负责向消息提供者发送应答信息
 * @Auth lovin
 * @Date 2018/09/10 15:58
 */
@Component
public class ReplyTo {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final String consumerMsg, Message produerMessage) throws JMSException {
        jmsTemplate.send(produerMessage.getJMSReplyTo(), new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createTextMessage("QueueReceiver1 accept msg" +consumerMsg);
                return msg;
            }
        });
    }
}
