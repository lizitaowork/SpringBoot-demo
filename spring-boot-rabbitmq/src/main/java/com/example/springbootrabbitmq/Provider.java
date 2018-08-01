package com.example.springbootrabbitmq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者（消息发送者）
 * Created by zitao.li on 2018/8/1.
 */
@Component
public class Provider {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param object
     */
    public void send(Object object){
        System.out.println("Sender : " + JSON.toJSONString(object));
        this.rabbitTemplate.convertAndSend(QueueConstants.MESSAGE_EXCHANGE, QueueConstants.MESSAGE_ROUTE_KEY, object);
    }
}
