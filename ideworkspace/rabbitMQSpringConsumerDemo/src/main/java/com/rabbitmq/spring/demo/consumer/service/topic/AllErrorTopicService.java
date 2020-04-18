package com.rabbitmq.spring.demo.consumer.service.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Description 监听所有的错误日志主题的消费端
 * @Auth lovin
 * @Date 2018/09/12 10:34
 */
@Component
public class AllErrorTopicService implements MessageListener{
    private Logger logger = LoggerFactory.getLogger(AllErrorTopicService.class);
    public void onMessage(Message message) {
        logger.info("Get message:"+new String(message.getBody()));
    }
}
