package com.example.springbootstarterhello.service;

import org.springframework.stereotype.Service;

/**
 * Created by zitao.li on 2018/7/26.
 */
@Service
public class HelloService {
    private String msg;

    public String sayHello(){
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
