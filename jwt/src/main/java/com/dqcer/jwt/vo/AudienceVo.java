package com.dqcer.jwt.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取JWT配置
 * @author dqcer
 * @description
 * @date 10:12 2020/3/14
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
public class AudienceVo {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}
