package com.example.springboot2websocket.biz.model;

/**
 * Created by zitao.li on 2018/8/3.
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}

