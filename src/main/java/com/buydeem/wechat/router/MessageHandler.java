package com.buydeem.wechat.router;

import com.buydeem.wechat.bean.message.ReceiveMessage;

/**
 * Created by zengchao on 2019/8/30.
 */
public interface MessageHandler {

    /**
     * 是否支持该消息处理
     * @param message
     * @return
     */
    boolean support(ReceiveMessage message);
    /**
     * 处理消息
     * @param message 消息
     * @return
     */
    Object handler(ReceiveMessage message);
}
