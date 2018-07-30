package com.example.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zitao.li on 2018/7/27.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(value = "/")
    public String index(){
        return "ws";
    }
}
