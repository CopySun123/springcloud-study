package com.copysun.openfeignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author copysun
 * 1、使用阿里的Druid连接池，需要排除DruidDataSourceAutoConfigure
 */
@SpringBootApplication(excludeName ={"com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure"})
@EnableDiscoveryClient
@EnableFeignClients({"com.copysun.openfeignservice.service"})
public class OpenfeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignServiceApplication.class, args);
	}

}
