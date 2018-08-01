package com.example.springbootrabbitmq.bean;

import java.io.Serializable;

/**
 * Created by zitao.li on 2018/8/1.
 */
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 296763681597798722L;
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
