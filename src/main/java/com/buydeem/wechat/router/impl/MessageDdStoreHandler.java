package com.buydeem.wechat.router.impl;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.mapper.ReceiveMessageMapper;
import com.buydeem.wechat.router.MessageStoreHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zengchao on 2019/8/30.
 */
@Service
public class MessageDdStoreHandler implements MessageStoreHandler {
    @Autowired
    private ReceiveMessageMapper receiveMessageMapper;

    @Override
    public void store(ReceiveMessage message) {
        receiveMessageMapper.insert(message);
    }
}
