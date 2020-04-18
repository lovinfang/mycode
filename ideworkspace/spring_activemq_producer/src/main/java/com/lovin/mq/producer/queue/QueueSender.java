package com.lovin.mq.producer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @Destription 队列消息生产者，发送消息到队列
 * @Auth lovin
 * @Date 2018/09/08 21:15
 */
@Component("queueSender")
public class QueueSender {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    @Autowired
    private GetResponse getResponse;

    public void send(String queueName,final String message){
        jmsTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createTextMessage(message);

                //配置消费者应答相关内容
                Destination tempDest = session.createTemporaryQueue(); //创建临时队列
                MessageConsumer responseConsumer = session.createConsumer(tempDest);
                responseConsumer.setMessageListener(getResponse);
                msg.setJMSReplyTo(tempDest); //告诉消费端应答的消息队列地址
                //消费者应答的id，发送出的消息和应答消息进行匹配
                String uid = System.currentTimeMillis()+"";
                msg.setJMSCorrelationID(uid);

                return msg;
            }
        });
    }
}
