package com.song.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.song.producer.ConnectionUtil;

/**
 * Created by Song on 2019/01/18.
 */
public class HelloWordConsumer {
    static String hello_topic = "hello";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(hello_topic, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("receive message body:{" + message + "}");
        };

        channel.basicConsume(hello_topic, false, deliverCallback, (consumerTag)-> {
            System.out.println("cancel call back!");
        });
    }
}
