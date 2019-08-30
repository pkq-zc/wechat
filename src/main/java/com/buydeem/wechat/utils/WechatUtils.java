package com.buydeem.wechat.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 微信工具类
 *
 * @author zengchao
 * @date 2019/8/30
 */
public final class WechatUtils {

    /**
     * 验证
     * @param signature
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean verify(String signature,String token, Long timestamp, Long nonce) {
        List<? extends Serializable> list = Arrays.asList(timestamp, token, nonce);
        StringBuilder sb = new StringBuilder();
        list.forEach(item -> sb.append(item.toString()));
        byte[] sha1 = DigestUtils.sha1(sb.toString().getBytes(Charset.forName("utf-8")));
        return Objects.equals(new String(sha1,Charset.forName("utf-8")),signature);
    }
}
