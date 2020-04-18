package com.lovin.mq.producer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Destription Topic生产者发送消息到Topic
 * @Auth lovin
 * @Date 2018/09/08 21:15
 */
@Component("topicSender")
public class TopicSender {

    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String queueName,final String message){
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createTextMessage(message);
                return msg;
            }
        });
    }
}
