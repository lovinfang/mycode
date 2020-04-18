package com.lovin.rabbitmq.consumer.nomal;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 处理错误级别的日志
 * @Auth lovin
 * @Date 2018/09/11 16:00
 */
public class ConsumerError {

//    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String EXCHANGE_NAME = "fanout_logs_1";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();//连接
        Channel channel = connection.createChannel();//信道
//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);//交换器

        //funout类型的交换器都 虽然定义只获取错误级别的日志，但是还是会将所有类型的日志获取
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);//交换器
        //声明随机队列
        String queueName = channel.queueDeclare().getQueue();
        String server = "error";
        channel.queueBind(queueName,EXCHANGE_NAME,server);
        System.out.println("Waiting message.......");

        Consumer consumerB = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("Accept:"+envelope.getRoutingKey()+":"+message);
            }
        };

        channel.basicConsume(queueName,true,consumerB);
    }


}
