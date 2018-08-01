package com.example.springbootrabbitmq.config;

import com.example.springbootrabbitmq.QueueConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zitao.li on 2018/8/1.
 */
@Configuration
public class RabbitConfig {
    /**
     * 交换机配置
     * @return
     */
    @Bean
    public DirectExchange addDirectExchange(){
        return (DirectExchange)ExchangeBuilder.directExchange(QueueConstants.MESSAGE_EXCHANGE)
                .durable(true)
                .build();
    }

    /**
     * 消息队列声明
     * @return
     */
    @Bean
    public Queue addQueue(){
        return QueueBuilder.durable(QueueConstants.MESSAGE_QUEUE_NAME).build();
    }

    /**
     * 消息绑定
     * @return
     */
    @Bean
    public Binding messageBinding(){
        return BindingBuilder.bind(addQueue())
                .to(addDirectExchange())
                .with(QueueConstants.MESSAGE_ROUTE_KEY);
    }
}
