package com.copysun.openfeignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author copysun
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.copysun.openfeignservice.outservice"})
public class OpenfeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignServiceApplication.class, args);
	}

}
