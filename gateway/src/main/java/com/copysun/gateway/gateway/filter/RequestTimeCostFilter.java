package com.copysun.gateway.gateway.filter;

import cn.hutool.core.date.DateUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author CopySun
 * @date 2020/11/30 10:38
 *
 */
@Configuration
public class  RequestTimeCostFilter implements GlobalFilter, Ordered {

    private static final String REQUEST_TIME_BEGIN="requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //记录请求开始时间
        exchange.getAttributes().put(REQUEST_TIME_BEGIN,DateUtil.currentSeconds());

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long startTime=exchange.getAttribute(REQUEST_TIME_BEGIN);
            if(startTime!=null){
                System.out.println(exchange.getRequest().getURI()+"耗时："+(DateUtil.currentSeconds()-startTime));
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
