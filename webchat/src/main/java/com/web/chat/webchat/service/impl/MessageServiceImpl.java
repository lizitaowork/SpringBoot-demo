package com.web.chat.webchat.service.impl;

import com.web.chat.webchat.biz.model.ReceiveMessage;
import com.web.chat.webchat.dao.MessageMapper;
import com.web.chat.webchat.dao.bean.Message;
import com.web.chat.webchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zitao.li on 2018/8/3.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int saveMessage(ReceiveMessage receiveMessage) {
        Message message = new Message();
        message.setContent(receiveMessage.getContent());
        message.setSendUserid(receiveMessage.getSender());
        message.setReceiveUserid(receiveMessage.getReceiver());
        message.setStatus("1");
        return messageMapper.insertSelective(message);
    }
}
