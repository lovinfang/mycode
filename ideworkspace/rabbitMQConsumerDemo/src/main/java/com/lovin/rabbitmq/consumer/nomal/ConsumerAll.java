package com.lovin.rabbitmq.consumer.nomal;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 处理所有日志
 * @Auth lovin
 * @Date 2018/09/11 15:43
 */
public class ConsumerAll {
//    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String EXCHANGE_NAME = "fanout_logs_1";

    public static void main(String[] argv) throws IOException,
            InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();//连接
        Channel channel = connection.createChannel();//信道
//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);//交换器
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);//交换器
        //声明随机队列
        String queueName = channel.queueDeclare().getQueue();
        String[]serverities = {"error","info","warning"};
        for(String server:serverities){
            //队列和交换器的绑定
            channel.queueBind(queueName,EXCHANGE_NAME,server);
        }
        System.out.println("Waiting message.......");


        //实现侦听器
        Consumer consumerA = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Accept:"+envelope.getRoutingKey()+":"+message);
            }
        };

        //queueName : 消费的队列
        //true ： 消息自动确认
        //consumerA ： 侦听   异步
        channel.basicConsume(queueName,true,consumerA);

    }
}
