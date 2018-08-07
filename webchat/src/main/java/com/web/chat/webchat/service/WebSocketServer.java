package com.web.chat.webchat.service;

import com.alibaba.fastjson.JSON;
import com.web.chat.webchat.biz.model.ReceiveMessage;
import com.web.chat.webchat.util.ReceiverTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by zitao.li on 2018/7/27.
 */
@ServerEndpoint(value = "/websocket/{userId}")
@Component
@Slf4j
public class WebSocketServer {
    @Resource
    private MessageService messageService;
    //当前在线人数，设计为线程安全
    private static int onlineCount = 0;
    //存放每个客户端对应的WebSocketServer对象，线程安全
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //客户端的连接会话session
    private Session session;
    //用户信息
    private Integer userId;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userId") Integer userId, Session session) {
        this.session = session;
        this.userId = userId;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线人数加1
        log.info("用户【{}】登录！当前在线人数为【{}】", userId, getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("用户【{}】注销！当前在线人数为{}", this.userId, getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("来自客户端的消息:" + message);
        ReceiveMessage receiveMessage = JSON.parseObject(message, ReceiveMessage.class);
        messageHanler(receiveMessage);
    }

    /**
     * 异常处理方法
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 向客户端发送消息
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) {
        try{
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ioe){
            log.error("websocket IO异常, message={}", message, ioe);
        } catch (Exception e){
            log.error("消息发送失败，message={}",message, e);
        }
    }

    /**
     * 消息处理方法
     * 收到客户端发送的消息，判断消息接收者类型
     * 好友：消息发送给对应的好友，并保存消息；
     * 群：消息发送给对应的群里面的所有人，并保存消息；
     * 群发：发送给选中人，并保存消息。
     * @param receiveMessage
     */
    public void messageHanler(ReceiveMessage receiveMessage){
        if(receiveMessage == null || StringUtils.isEmpty(receiveMessage.getContent())){
            log.error("消息内容为空，receiveMessage={}", JSON.toJSONString(receiveMessage));
            return;
        }

        if(receiveMessage.getReceiver() == null){
            log.error("消息接收者为空，receiveMessage={}", JSON.toJSONString(receiveMessage));
            return ;
        }

        Integer receiverTypeCode = receiveMessage.getReceiverTypeCode();
        if(receiverTypeCode == null){
            log.error("消息接受者类型为空，receiveMessage={}", JSON.toJSONString(receiveMessage));
            return;
        }

        try{
            String content = receiveMessage.getContent();
            Integer receiverId = receiveMessage.getReceiver();

            if(ReceiverTypeEnum.FRIEND.getCode().equals(receiverTypeCode)){
                webSocketSet.stream()
                        .filter(w -> w.userId == receiverId)
                        .forEach(webSocketServer -> webSocketServer.sendMessage(content));

            }else if(ReceiverTypeEnum.GROUP.getCode().equals(receiverTypeCode)){
                //发送到群
            }else if(ReceiverTypeEnum.MASS.getCode().equals(receiverTypeCode)){
                //群发
                sendAll(content);
            }else{
                log.error("不支持的消息接收类型，receiverTypeCode={}",receiverTypeCode);
            }

        }catch (Exception e){
            log.error("消息发送异常，receiveMessage={}", JSON.toJSONString(receiveMessage), e);
        }
    }

    /**
     * 群发(所有好友，不包括群)
     */
    public void sendAll(String message) {
        webSocketSet.stream()
                .filter(socket -> socket.session != this.session)
                .forEach(w -> w.sendMessage(message));
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
