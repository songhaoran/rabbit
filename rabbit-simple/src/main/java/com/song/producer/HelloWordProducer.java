package com.song.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by Song on 2019/01/18.
 */
public class HelloWordProducer {

    static String hello_topic = "hello";

    public static void main(String[] args) throws Exception{

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();


        // 声明队列:仅当指定队列不存在时创建
        // 参数1: 队列名称
        // 参数2: 是否持久化队列. 为true:持久化到erlang数据库,当程序停止重启后, 消息不会丢失
        // 参数3: 是否私有化队列. 为true:关闭连接后删除该队列;只有当前channel可以访问该队列,适用于只有一个消费者的情况
        // 参数4: 是否自动删除
        // 参数5: 其他参数
        channel.queueDeclare(hello_topic, false, false, false, null);

        //发送
        channel.basicPublish("",hello_topic, null, "hello word!".getBytes());

        //关闭通道
        channel.close();
    }
}
