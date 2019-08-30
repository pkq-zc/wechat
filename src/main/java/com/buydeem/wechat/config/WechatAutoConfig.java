package com.buydeem.wechat.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zengchao on 2019/8/30.
 */
@Configuration
@EnableConfigurationProperties(value = {WechatProperties.class})
public class WechatAutoConfig {

}
