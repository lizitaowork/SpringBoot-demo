package com.example.springbootrabbitmq;

import com.alibaba.fastjson.JSON;
import com.example.springbootrabbitmq.bean.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消费者（消息接受者）
 * Created by zitao.li on 2018/8/1.
 */
@Component
@RabbitListener(queues = QueueConstants.MESSAGE_QUEUE_NAME)
public class Receiver {
    /**
     * 接受消息
     * @RabbitHandler会自动获取消息
     * @param messageEntity
     */
    @RabbitHandler
    public void handler(@Payload MessageEntity messageEntity){
        System.out.println("Receiver : " + JSON.toJSONString(messageEntity));
    }
}
