package com.lovin.rabbitmq.consumer.consumerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 消息被拒绝
 * @Auth lovin
 * @Date 2018/09/11 17:20
 */
public class ClientConsumerReject {

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
                //拒绝消息 true:消费端消费消息被拒绝之后会重试直到被其他的消费端正确消费为止   false:消息被拒绝不会被重试，也不会被其他消费端消费
                this.getChannel().basicReject(envelope.getDeliveryTag(),true);
                System.out.println("Reject:"+envelope.getRoutingKey()
                        +":"+new String(body,"UTF-8"));
            }
        };

        channel.basicConsume(queueName,false,consumerB);
    }
}
