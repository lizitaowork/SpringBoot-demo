package com.web.chat.webchat.util;

/**
 * 目的地类型
 * Created by zitao.li on 2018/8/3.
 */
public enum ReceiverTypeEnum {
    FRIEND("好友", 0),
    GROUP("群", 1),
    MASS("群发", 2);

    private String name;
    private Integer code;

    ReceiverTypeEnum(String name, Integer code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
