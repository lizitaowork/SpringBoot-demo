package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.Provider;
import com.example.springbootrabbitmq.bean.MessageEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zitao.li on 2018/8/1.
 */
@RestController
@RequestMapping("/rabbitmq")
public class MessageController {
    @Resource
    private Provider provider;

    @RequestMapping("/send")
    public String send(MessageEntity message){
        provider.send(message);
        return "success";
    }
}
