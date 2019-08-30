package com.buydeem.wechat.router.impl;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.router.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by zengchao on 2019/8/30.
 */
@Component
public class MessageHandlerManager{
    @Autowired
    private ApplicationContext context;


    public Optional<MessageHandler> select(ReceiveMessage message){
        Collection<MessageHandler> handlers = context.getBeansOfType(MessageHandler.class).values();
        return handlers.stream()
                .filter(handler -> handler.support(message)).findAny();
    }

}
