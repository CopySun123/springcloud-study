package com.copysun.rabbitmqprovider.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hspcadmin
 */
@Configuration
public class RabbitConfig {

    private static final String DIRECT_EXCHANGE="testDirectExchange";
    private static final String DIRECT_QUEUE1="directQueue1";
    private static final String DIRECT_QUEUE2="directQueue2";

    /**
     * 直连型交换机
     * @return
     */
    @Bean()
    public Exchange directExchange(){
       return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Queue directQueue1(){
        return new Queue(DIRECT_QUEUE1);
    }
    @Bean
    public Queue directQueue2(){
        return new Queue(DIRECT_QUEUE2);
    }

    @Bean
    public Binding exchangeBinding1(){
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("key1").noargs();
    }
    @Bean
    public Binding exchangeBinding2(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("key1").noargs();
    }
}
