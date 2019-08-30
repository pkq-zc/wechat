package com.buydeem.wechat.router;

import com.buydeem.wechat.bean.message.ReceiveMessage;

/**
 * 消息存储接口
 * @author zengchao
 * @date 2019/8/30
 */
public interface MessageStoreHandler {
    /**
     * 存储消息
     * @param message
     */
    void store(ReceiveMessage message);
}
