package com.example.springbootredis.bean.vo;


import com.example.springbootredis.bean.User;

import java.io.Serializable;

/**
 * Created by zitao.li on 2018/7/30.
 */
public class RedisRequestVO<T> implements Serializable {
    private static final long serialVersionUID = 1039261022234588458L;
    private String key;
    private T data;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
