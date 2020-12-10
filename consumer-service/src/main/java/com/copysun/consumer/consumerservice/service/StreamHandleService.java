package com.copysun.consumer.consumerservice.service;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author CopySun
 * @date 2020/11/16 16:25
 */
@Service
@Slf4j
public class StreamHandleService {

    @StreamListener(Sink.INPUT)
    public void receive1(String message, @Header("amqp_channel")Channel channel,@Header("amqp_deliveryTag") long deliveryTag,
                         @Header("amqp_redelivered") boolean redelivered){
        log.info("收到消息:"+message);
        try {

            /** 手动ack模式
            * deliveryTag： 消息序号
            * redelivered：
            **/
            for (int i = 1; i <=100 ; i++) {
                System.out.println("哈哈"+i);
            }
            channel.basicAck(deliveryTag,true);
        } catch (IOException e) {
            try {
                channel.basicNack(deliveryTag,false,true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
