package com.buydeem.wechat.router;

import com.buydeem.wechat.bean.message.ReceiveMessage;

/**
 * 重复消息处理器
 * Created by zengchao on 2019/8/30.
 */
public interface RepeatMessageHandler {

    /**
     * 是否是重复消息
     * @param message
     * @return
     */
    boolean isRepeatMessage(ReceiveMessage message);

    /**
     * 重复消息处理
     * @param message
     * @return
     */
    Object process(ReceiveMessage message);
}
