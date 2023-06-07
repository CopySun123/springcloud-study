package com.copysun.rabbitmqprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RabbitmqProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProviderApplication.class, args);
	}

}
