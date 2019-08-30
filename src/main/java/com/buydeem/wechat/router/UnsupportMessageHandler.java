package com.buydeem.wechat.router;

import com.buydeem.wechat.bean.message.ReceiveMessage;

/**
 * Created by zengchao on 2019/8/30.
 */
public interface UnsupportMessageHandler {

    Object handler(ReceiveMessage message);
}
