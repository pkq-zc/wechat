package com.buydeem.wechat.bean.message;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * 微信基础消息
 * @author zengchao
 * @date 2019/8/30
 */
@Data
@JacksonXmlRootElement(localName = "xml")
@TableName("t_message")
public class ReceiveMessage {
    /**
     * 开发者微信号
     */
    @JacksonXmlProperty(localName = "ToUserName")
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    @JacksonXmlProperty(localName = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @JacksonXmlProperty(localName = "CreateTime")
    private Long createTime;
    /**
     * 消息类型，event
     */
    @JacksonXmlProperty(localName = "MsgType")
    private String msgType;
    /**
     * 事件类型，subscribe
     */
    @JacksonXmlProperty(localName = "Event")
    private String event;
    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    @JacksonXmlProperty(localName = "EventKey")
    private String eventKey;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @JacksonXmlProperty(localName = "Ticket")
    private String ticket;
    /**
     * 文本内容
     */
    @JacksonXmlProperty(localName = "Content")
    private String content;

}
