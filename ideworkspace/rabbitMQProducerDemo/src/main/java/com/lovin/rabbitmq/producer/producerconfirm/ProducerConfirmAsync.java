package com.lovin.rabbitmq.producer.producerconfirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 测试发送端异步确认
 * @Auth lovin
 * @Date 2018/09/11 18:36
 * 测试异步确认发送端的消费端代码为 ProducerConfirmConsumer.java
 */
public class ProducerConfirmAsync {

    private final static String EXCHANGE_NAME = "producer_confirm";

    public static void main(String[] args) throws IOException, TimeoutException,
            InterruptedException {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();

        // 设置MabbitMQ所在主机ip或者主机名
        factory.setHost("127.0.0.1");
        // 创建一个连接
        Connection connection = factory.newConnection();
        //连接被关闭的时候会调用此方法
        //connection.addShutdownListener();

        // 创建一个信道
        Channel channel = connection.createChannel();
        // 指定转发
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        //将信道设置为发送方确认
        channel.confirmSelect();

        //信道被关闭的时候会调用此方法
        //channel.addShutdownListener();

        //deliveryTag代表了（channel）唯一的投递标志
        //multiple:false  是否将小于 deliveryTag的消息一次性确认
        channel.addConfirmListener(new ConfirmListener() {
            // rabbitMq收到消息之后返回的消息
            public void handleAck(long deliveryTag, boolean multiple)
                    throws IOException {
                System.out.println("Ack deliveryTag="+deliveryTag
                        +"multiple:"+multiple);
            }

            //rabbitmq如果因为自身内部没有消息丢失的话，给生产者消息的确认
            public void handleNack(long deliveryTag, boolean multiple)
                    throws IOException {
                System.out.println("Ack deliveryTag="+deliveryTag
                        +"multiple:"+multiple);
            }
        });

        //1、mandatory参数为true，rabbitmq在投递消息时无法找到一个合适的队列，消息返回给生产者
        //                  false 丢弃消息(缺省)
        channel.addReturnListener(new ReturnListener() {
            public void handleReturn(int replyCode, String replyText,
                                     String exchange, String routingKey,
                                     AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String msg = new String(body);
                System.out.println("replyText:"+replyText);
                System.out.println("exchange:"+exchange);
                System.out.println("routingKey:"+routingKey);
                System.out.println("msg:"+msg);
            }
        });


        String[] severities={"error","info","warning"};
        for(int i=0;i<3;i++){
            String severity = severities[i%3];
            // 发送的消息
            String message = "Hello World_"+(i+1)+("_"+System.currentTimeMillis());
            //true 如果发送的消息没有找到合适的队列的话，那么调用 addReturnListener
            //false 如果发送的消息没有找到合适的队列的话 都会调用 addConfirmListener
            channel.basicPublish(EXCHANGE_NAME, severity, true,
                    null, message.getBytes());
            //channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY,null,msg.getBytes());
            System.out.println("----------------------------------------------------");
            System.out.println(" Sent Message: [" + severity +"]:'"+ message + "'");
            Thread.sleep(200);
        }

        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}
