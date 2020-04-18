package com.lovin.rabbitmq.consumer.consumerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 验证客户端延迟响应(宕机)的情形 如果宕机，那么消息会发送给其他的消费端
 * @Auth lovin
 * @Date 2018/09/11 17:12
 */
public class ClientConsumerSlowAck {

    private static final String EXCHANGE_NAME = "direct_cc_confirm";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();//连接
        Channel channel = connection.createChannel();//信道
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);//交换器

        //声明队列
        String queueName = "consumer_confirm";
        channel.queueDeclare(queueName,false,false,
                false,null);

        String server = "error";
        channel.queueBind(queueName,EXCHANGE_NAME,server);
        System.out.println("Waiting message.......");

        Consumer consumerB = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                try {
                    Thread.sleep(25000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message = new String(body,"UTF-8");
                System.out.println("Accept:"+envelope.getRoutingKey()+":"+message);
                //this.getChannel().basicAck(envelope.getDeliveryTag(),false); 消费者可以拿到消息，但是不进行确认，那么消息会一直存在在队列中,如果宕机，其他消费端一样会消费
            }
        };

        channel.basicConsume(queueName,false,consumerB);
    }
}
