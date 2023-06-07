package com.copysun.rabbitmqconsume.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * @Author copysun
 * @Date: Create in 9:35 2023/5/11
 * @Desc 自定义SimpleRabbitListenerContainerFactory配置
 */
//@Configuration
@Slf4j
public class RabbitListenerConfig {

	@Bean("consumeContainerFactory")
	public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, CachingConnectionFactory connectionFactory){
		SimpleRabbitListenerContainerFactory containerFactory=new SimpleRabbitListenerContainerFactory();
		containerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);//应答模式

		//设置重试策略
		containerFactory.setAdviceChain(
				RetryInterceptorBuilder
						.stateful()
						.maxAttempts(3)
						.backOffOptions(1000,2,15000)
						.recoverer((message, throwable) -> {
							log.info("进来了......");
						})
						.build());

		//containerFactory.setConcurrentConsumers(1);//最小消费者数量
		//containerFactory.setMaxConcurrentConsumers(10);//最大消费者数量
		configurer.configure(containerFactory,connectionFactory);
		return containerFactory;
	}
}
