package com.copysun.nacos.nacosserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CopySun
 * @date 2020/12/25 9:57
 * @Description
 */
@RestController
@RefreshScope
public class Demo {

    @Value("${username}")
    private String username;

    @PostMapping("/get")
    public void test(){
        System.out.println(username);
    }
}
