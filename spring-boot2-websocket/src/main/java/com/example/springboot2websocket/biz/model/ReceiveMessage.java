package com.example.springboot2websocket.biz.model;

/**
 * Created by zitao.li on 2018/8/3.
 */
public class ReceiveMessage {
    private String content;

    public ReceiveMessage(){}

    public ReceiveMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
