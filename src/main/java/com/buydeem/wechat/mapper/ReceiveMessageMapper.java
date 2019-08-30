package com.buydeem.wechat.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buydeem.wechat.bean.message.ReceiveMessage;

/**
 * Created by zengchao on 2019/8/30.
 */
@DS(value = "master")
public interface ReceiveMessageMapper extends BaseMapper<ReceiveMessage> {
}
