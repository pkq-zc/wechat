package com.buydeem.wechat.router.impl;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.bean.message.ReplyMessage;
import com.buydeem.wechat.router.UnsupportMessageHandler;
import org.springframework.stereotype.Component;

/**
 * Created by zengchao on 2019/8/30.
 */
@Component
public class DefaultUnsupportMessageHandler implements UnsupportMessageHandler {

    @Override
    public Object handler(ReceiveMessage message) {
        return ReplyMessage.builder()
                .fromUserName(message.getToUserName())
                .toUserName(message.getFromUserName())
                .content("无法处理的消息")
                .msgType("text")
                .createTime(System.currentTimeMillis()/1000)
                .build();
    }
}
