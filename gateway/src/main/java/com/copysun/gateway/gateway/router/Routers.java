package com.copysun.gateway.gateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author CopySun
 * @date 2020/11/27 17:07
 */
@Component
public class Routers {

    @Bean
    public RouteLocator producerRouteLocator(RouteLocatorBuilder routeBuilder){
        return routeBuilder.routes()
                .route("product_router",r->r.path("/sendMsg")
                        .uri("lb://producer-service"))
                .build();
    }



}
