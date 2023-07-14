package com.copysun.nacosdemo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @Author:CopySun
 * @CreateTime:2023/7/12 14:28
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "user")
public class TestBean implements Serializable {

    private String userName;

    private String password;
}
