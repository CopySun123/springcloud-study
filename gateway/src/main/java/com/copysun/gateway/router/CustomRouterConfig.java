package com.copysun.gateway.router;

import com.copysun.gateway.handler.ValidateCodeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @Author:CopySun
 * @CreateTime:2023/8/23 9:44
 * @Description: 路由配置信息
 */
@Configuration
public class CustomRouterConfig {

    @Autowired
    private ValidateCodeHandler validateCodeHandler;

    @Bean
    public RouterFunction routerFunction(){
        return RouterFunctions.route(
                RequestPredicates.GET("/code").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                validateCodeHandler);
    }
}
