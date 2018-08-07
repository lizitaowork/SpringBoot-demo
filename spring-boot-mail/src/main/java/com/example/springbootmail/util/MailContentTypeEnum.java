package com.example.springbootmail.util;

/**
 * Created by zitao.li on 2018/8/2.
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;

    MailContentTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
