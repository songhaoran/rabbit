package com.song.producer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by Song on 2019/01/18.
 */
public class ConnectionUtil {

    public static Connection getConnection() throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.107.65.108");
//        connectionFactory.setPort(15672);
//        connectionFactory.setUsername("song");
//        connectionFactory.setPassword("song");
//        connectionFactory.setVirtualHost("/song");

        return connectionFactory.newConnection();
    }
}
