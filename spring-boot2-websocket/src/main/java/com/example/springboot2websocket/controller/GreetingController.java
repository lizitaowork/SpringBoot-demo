package com.example.springboot2websocket.controller;

/**
 * Created by zitao.li on 2018/8/3.
 */
import com.example.springboot2websocket.biz.model.Greeting;
import com.example.springboot2websocket.biz.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + message.getName() + "!");
//    }

}
