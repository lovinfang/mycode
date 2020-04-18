package com.rabbitmq.spring.demo.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description RabbitMQ Controller
 * @Auth lovin
 * @Date 2018/09/12 10:02
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    private Logger logger = LoggerFactory.getLogger(RabbitMqController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping("/fanoutSender")
    public String fanoutSender(@RequestParam("message")String message){
        String opt="";
        try {
            for(int i=0;i<3;i++){
                String str = "Fanout,the message_"+i+" is : "+message;
                logger.info("**************************Send Message:["+str+"]");
                rabbitTemplate.send("fanout-exchange","",
                        new Message(str.getBytes(),new MessageProperties()));

            }
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }

    @ResponseBody
    @RequestMapping("/topicSender")
    public String topicSender(@RequestParam("message")String message){
        String opt="";
        try {
            String[] severities={"error","info","warning"};
            String[] modules={"email","order","user"};
            for(int i=0;i<severities.length;i++){
                for(int j=0;j<modules.length;j++){
                    String routeKey = severities[i]+"."+modules[j];
                    String str = "the message is [rk:"+routeKey+"]["+message+"]";
                    rabbitTemplate.send("topic-exchange",routeKey,
                            new Message(str.getBytes(),new MessageProperties()));

                }
            }
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }
}
