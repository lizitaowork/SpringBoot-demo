package com.example.springbootstarterhello.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zitao.li on 2018/7/26.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
