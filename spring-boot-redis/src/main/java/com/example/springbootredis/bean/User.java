package com.example.springbootredis.bean;

import java.io.Serializable;

/**
 * Created by zitao.li on 2018/7/30.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8499434066412998323L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
