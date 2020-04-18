package com.lovin.rabbitmq.consumer.consumerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 消费端自行确认
 * @Auth lovin
 * @Date 2018/09/11 16:44
 */
public class ClientConsumerAck {

    private static final String EXCHANGE_NAME = "direct_cc_confirm";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();//连接
        Channel channel = connection.createChannel();//信道
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);//交换器

        //声明队列(自定义)
        String queueName = "consumer_confirm";
        //queueName:队列名  false:是否持久化 false:是否私有  false:是否自动删除  null:声明队列的相关参数
        channel.queueDeclare(queueName,false,false,false,null);

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
                this.getChannel().basicAck(envelope.getDeliveryTag(),false); //消费者自行确认  envelope.getDeliveryTag():信封投递标志符   false:投递是否进行批量回复
            }
        };

        channel.basicConsume(queueName,false,consumerB);  //false不自动应答
    }
}
