package com.lovin.rabbitmq.producer.normal;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description rabbitMQ direct exchange 交换器
 * @Auth lovin
 * @Date 2018/09/11 15:11
 * 测试 消费端中 ConsumerAll.java 和 ConsumerError.java direct类型交换器
 */
public class DirectProducer {

    private final static String EXCHANGE_NAME = "direct_logs";  //定义一个交换器

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        /* factory.setUsername(..);   在其他机器上安装rabbitmq 用户名使用 guest 是无法访问的
           factory.setPort();
           factory.setVirtualHost();*/

        Connection connection = factory.newConnection();//连接

        Channel channel = connection.createChannel();//信道

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);//交换器

        String[]serverities = {"error","info","warning"};

        for(int i=0;i<3;i++){
            String server = serverities[i];
            String message = "Hello world_"+(i+1);

            //BasicProperties.deliveryMode 如果是持久化，则为2
            channel.basicPublish(EXCHANGE_NAME,server,null,message.getBytes());
            System.out.println("Sent "+server+":"+message);
        }
        channel.close();
        connection.close();
    }
}
