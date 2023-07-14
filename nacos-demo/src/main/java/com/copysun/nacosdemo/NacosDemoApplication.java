package com.copysun.nacosdemo;

import com.copysun.nacosdemo.domain.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author hspcadmin
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@EnableConfigurationProperties({TestBean.class})
public class NacosDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosDemoApplication.class, args);
	}

}
