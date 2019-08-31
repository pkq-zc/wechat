package com.buydeem.wechat.controller;

import com.buydeem.wechat.bean.message.ReceiveMessage;
import com.buydeem.wechat.config.WechatProperties;
import com.buydeem.wechat.router.MessageRouter;
import com.buydeem.wechat.utils.WechatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 微信接口
 *
 * @author zengchao
 * @date 2019/8/30
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WechatProperties properties;
    @Autowired
    private MessageRouter messageRouter;

    /**
     * 服务器校验接口
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机数字
     * @param echostr   回应字符串
     * @return
     */
    @GetMapping("/receive")
    public Object verify(@RequestParam("signature") String signature,
                         @RequestParam("timestamp") Long timestamp,
                         @RequestParam("nonce") Long nonce,
                         @RequestParam("echostr") String echostr) {
        boolean verify = WechatUtils.verify(signature, properties.getToken(), timestamp, nonce);
        return verify ? echostr : false;
    }

    /**
     * 接收业务消息
     * @return
     */
    @PostMapping(value = "/receive",
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.TEXT_XML_VALUE},
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Object receiveMessage(@RequestBody ReceiveMessage message) {
        return messageRouter.router(message);
    }
}
