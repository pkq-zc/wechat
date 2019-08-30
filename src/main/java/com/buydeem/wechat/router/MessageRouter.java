package com.buydeem.wechat.router;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.router.impl.MessageHandlerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息路由
 * @author zengchao
 * @date 2019/8/30
 */
@Component
public class MessageRouter {
    @Autowired
    private RepeatMessageHandler repeatMessageHandler;
    @Autowired
    private MessageStoreHandler messageStoreHandler;
    @Autowired
    private MessageHandlerManager messageHandlerManager;
    @Autowired
    private UnsupportMessageHandler unsupportMessageHandler;

    /**
     * 消息路由
     * @param message
     * @return
     */
    public Object router(ReceiveMessage message){
        //1.验证消息是否重复
        boolean repeat = repeatMessageHandler.isRepeatMessage(message);
        if (repeat){
            repeatMessageHandler.process(message);
        }
        //2.存储消息
        messageStoreHandler.store(message);
        //3.处理消息
        Optional<MessageHandler> optional = messageHandlerManager.select(message);
        return optional.isPresent() ? optional.get().handler(message) : unsupportMessageHandler.handler(message);
    }
}
