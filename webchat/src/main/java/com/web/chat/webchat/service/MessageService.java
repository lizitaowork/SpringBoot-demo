package com.web.chat.webchat.service;

import com.web.chat.webchat.biz.model.ReceiveMessage;
import org.springframework.stereotype.Service;

/**
 * Message业务类
 * Created by zitao.li on 2018/8/2.
 */
@Service
public interface MessageService {
    int saveMessage(ReceiveMessage receiveMessage);
}
