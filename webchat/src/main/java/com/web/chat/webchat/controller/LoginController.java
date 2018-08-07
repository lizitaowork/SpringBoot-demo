package com.web.chat.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zitao.li on 2018/8/2.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/")
    public String toWs(){
        return "ws";
    }
}
