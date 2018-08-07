package com.web.chat.webchat.biz.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于接受webSocket消息
 * Created by zitao.li on 2018/8/3.
 */
@Data
public class ReceiveMessage {
    //消息内容
    private String content;
    //消息发送者
    private Integer sender;
    //消息接收者类型：0：好友，1：群，2：群发
    private Integer receiverTypeCode;
    //消息接收者(用于群发时)
    private List<Integer> receivers = new ArrayList<>();
    //消息接收者（用于发送好友和群聊）
    private Integer receiver;
}
