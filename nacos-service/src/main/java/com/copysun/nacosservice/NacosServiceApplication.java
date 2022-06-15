package com.copysun.nacosservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;

/**
 * @author hspcadmin
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class NacosServiceApplication {

	@Value(value = "${service.name}")
	private String serviceName;

	@PostConstruct
	public void testServiceName(){
		System.out.println(serviceName);
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosServiceApplication.class, args);
	}

}
