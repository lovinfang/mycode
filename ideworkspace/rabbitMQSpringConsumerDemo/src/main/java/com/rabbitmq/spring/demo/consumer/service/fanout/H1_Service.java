package com.rabbitmq.spring.demo.consumer.service.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Description 消费者定义
 * @Auth lovin
 * @Date 2018/09/12 10:29
 */
public class H1_Service implements MessageListener{
    private Logger logger = LoggerFactory.getLogger(H1_Service.class);
    public void onMessage(Message message) {
        logger.info("Get message:"+new String(message.getBody()));
    }
}
