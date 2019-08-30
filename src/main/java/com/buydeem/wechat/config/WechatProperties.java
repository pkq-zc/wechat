package com.buydeem.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

/**
 * 微信配置类
 * @author zengchao
 * @date 2019/8/30
 */
@Data
@ConfigurationProperties(prefix = "wechat.config")
public class WechatProperties {
    @NotBlank(message = "appId不能为空")
    private String appId;
    @NotBlank(message = "appSecret不能为空")
    private String appSecret;
    @NotBlank(message = "token不能为空")
    private String token;
}
