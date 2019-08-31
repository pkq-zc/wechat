package com.buydeem.wechat.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Stream;

/**
 * 微信工具类
 *
 * @author zengchao
 * @date 2019/8/30
 */
@Slf4j
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
        StringBuilder sb = new StringBuilder();
        Stream.of(token,timestamp.toString(),nonce.toString()).sorted(String::compareTo).forEach(sb::append);
        String sig = DigestUtils.sha1Hex(sb.toString().getBytes());
        log.info("cal sign:{}",sig);
        log.info("receive sing:{}",signature);
        return Objects.equals(sig,signature);
    }
}
