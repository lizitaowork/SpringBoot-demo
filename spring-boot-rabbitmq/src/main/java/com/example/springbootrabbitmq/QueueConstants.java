package com.example.springbootrabbitmq;

/**
 * 队列常量信息
 * Created by zitao.li on 2018/8/1.
 */
public interface QueueConstants {
    /**
     * 消息交换
     */
    String MESSAGE_EXCHANGE = "spring.boot.message.direct.exchange";

    /**
     * 消息队列名称
     */
    String MESSAGE_QUEUE_NAME = "message.queue";

    /**
     * 消息路由键
     */
    String MESSAGE_ROUTE_KEY = "message.send";
}
