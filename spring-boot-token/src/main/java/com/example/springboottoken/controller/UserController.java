package com.example.springboottoken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zitao.li on 2018/8/2.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @RequestMapping("/login")
    public String login(){
        return null;
    }

    @RequestMapping("/regist")
    public String regist(){
        return null;
    }

    @RequestMapping("/logout")
    public String logout(){
        return null;
    }
}
