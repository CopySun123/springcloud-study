package com.copysun.nacosdemo;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class NacosDemoApplication {
	@Value("${name}")
	private String name;

	@PostConstruct()
	public void getName(){
		log.info(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosDemoApplication.class, args);
	}

}
