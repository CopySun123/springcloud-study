package com.copysun.nacosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hspcadmin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosServiceApplication.class, args);
	}

}
