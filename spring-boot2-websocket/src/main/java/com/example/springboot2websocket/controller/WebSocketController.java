package com.example.springboot2websocket.controller;

import com.example.springboot2websocket.biz.model.ReceiveMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by zitao.li on 2018/8/3.
 */
@Controller
public class WebSocketController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ReceiveMessage get(ReceiveMessage receiveMessage) throws Exception{
        return new ReceiveMessage("Hello, " + receiveMessage.getContent());
    }
}
