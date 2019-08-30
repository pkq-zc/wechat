package com.buydeem.wechat.router.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.mapper.ReceiveMessageMapper;
import com.buydeem.wechat.router.RepeatMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zengchao on 2019/8/30.
 */
@Service
public class RepeatDbMessageHandler implements RepeatMessageHandler {
    @Autowired
    private ReceiveMessageMapper receiveMessageMapper;

    @Override
    public boolean isRepeatMessage(ReceiveMessage message) {
        QueryWrapper<ReceiveMessage> queryWrapper = new QueryWrapper<ReceiveMessage>()
                .eq("from_user_name", message.getFromUserName())
                .eq("create_time", message.getCreateTime());
        return receiveMessageMapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public Object process(ReceiveMessage message) {
        return "success";
    }
}
