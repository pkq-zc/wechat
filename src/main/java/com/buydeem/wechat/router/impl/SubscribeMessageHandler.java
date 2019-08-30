package com.buydeem.wechat.router.impl;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.bean.message.ReplyMessage;
import com.buydeem.wechat.router.MessageHandler;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by zengchao on 2019/8/30.
 */
@Component
public class SubscribeMessageHandler implements MessageHandler {

    @Override
    public boolean support(ReceiveMessage message) {
        return Objects.equals(message.getEvent(),"subscribe") && Objects.equals("event",message.getMsgType());
    }

    @Override
    public Object handler(ReceiveMessage message) {
        return ReplyMessage.builder()
                .fromUserName(message.getToUserName())
                .toUserName(message.getFromUserName())
                .content("谢谢你关注我们,目前我们只是测试中...")
                .msgType("text")
                .createTime(System.currentTimeMillis()/1000)
                .build();
    }
}
