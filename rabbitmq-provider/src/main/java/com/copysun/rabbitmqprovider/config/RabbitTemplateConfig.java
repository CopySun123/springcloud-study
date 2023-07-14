package com.copysun.rabbitmqprovider.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:CopySun
 * @CreateTime:2023/6/20 17:10
 * @Description:
 *
 * 测试ConfirmCallback和RetrunCallback两个的区别
 *  *
 *  * 先从总体的情况分析，推送消息存在四种情况：
 *  * ①消息推送到server，但是在server里找不到交换机
 *  * 结果：ConfirmCallback函数调用
 *  * ②消息推送到server，找到交换机了，但是没找到队列
 *  * 结果：ConfirmCallback函数调用,RetrunCallback函数调用
 *  * ③消息推送成功
 *  * 结果：ConfirmCallback函数调用
 */
@Configuration
@Slf4j
public class RabbitTemplateConfig {


    /**
     * 自定义RabbitTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate customeRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        //触发ReturnCallback函数必须设置为true
        rabbitTemplate.setMandatory(true);
        //设置确认发送到交换机的回调函数
        rabbitTemplate.setConfirmCallback((correlationData,b,error)->{
            if(b){
                log.info("confirm 消息发送确认成功...消息ID为：" + correlationData.getId());
            }else{
                log.error("confirm 消息发送确认失败...消息ID为：" + correlationData.getId() + " 失败原因: " + error);
            }
        });
        //设置确认消息已发送到队列的回调
        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            System.out.println("消息："+new String(message.getBody()));
            System.out.println("回应码："+i);
            System.out.println("回应信息："+s);
            System.out.println("交换机："+s1);
            System.out.println("路由键："+s2);
        });
        return rabbitTemplate;
    }
}
