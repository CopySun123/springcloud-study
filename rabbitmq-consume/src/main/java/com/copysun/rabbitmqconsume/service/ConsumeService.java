package com.copysun.rabbitmqconsume.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author copysun
 * @Date: Create in 15:48 2023/5/10
 * @Desc
 * 1、basic.reject方法拒绝deliveryTag对应的消息，第二个参数是否requeue，true则重新入队列，否则丢弃或者进入死信队列。
 * 该方法reject后，该消费者还是会消费到该条被reject的消息。
 * 2、basic.nack方法为不确认deliveryTag对应的消息，第二个参数是否应用于多消息，第三个参数是否requeue，
 * 与basic.reject区别就是同时支持多个消息，可以nack该消费者先前接收未ack的所有消息。nack后的消息也会被自己消费到。
 * 3、basic.recover是否恢复消息到队列，参数是是否requeue，true则重新入队列，
 * 并且尽可能的将之前recover的消息投递给其他消费者消费，而不是自己再次消费。false则消息会重新被投递给自己。
 */
@Service
@Slf4j
public class ConsumeService {

	@RabbitListener(queues = "directQueue1")
	public void receiveDirect1(Message message,Channel channel) throws IOException {
		String msg=new String(message.getBody());
		log.info("======directQueue1-消费者1收到消息:"+ msg +"======");
//		try{
//			int i=1/0;
//			String msg=new String(message.getBody());
//			log.info("======directQueue1收到消息:"+ msg +"======");
//			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//		}catch (Exception e){
//			//两个布尔值  第二个设为 false 则丢弃该消息 设为true 则返回给队列
//			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//			log.error("消费失败 我此次将返回给队列");
//		}
	}

	@RabbitListener(queues = "directQueue2")
	public void receiveDirect2(Message message){
		String msg=new String(message.getBody());
		log.info("======directQueue2收到消息:"+ msg +"======");
	}

	@RabbitListener(queues = "directQueue1")
	public void receiveDirect3(Message message){
		String msg=new String(message.getBody());
		log.info("======directQueue1-消费者2收到消息:"+ msg +"======");
	}

//	@RabbitListener(queues = "topicQueue1")
//	public void receiveTopic1(Message message){
//		String msg=new String(message.getBody());
//		log.info("======topicQueue1收到消息:"+ msg +"======");
//	}
//
//	@RabbitListener(queues = "topicQueue2")
//	public void receiveTopic2(Message message){
//		String msg=new String(message.getBody());
//		log.info("======topicQueue2收到消息:"+ msg +"======");
//	}
//
//	@RabbitListener(queues = "fanoutQueue1")
//	public void receiveFanout1(Message message, Channel channel) throws IOException {
//		String msg=new String(message.getBody());
//		long deliveryTag = message.getMessageProperties().getDeliveryTag();
//		try {
//			log.info("======fanoutQueue1收到消息成功:"+ msg +"======");
//			channel.basicAck(deliveryTag,false);
//		}catch (Exception e){
//			//第三个参数为true表示重新进入队列
//			channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
//			//channel.basicReject(deliveryTag,true);
//			//channel.basicRecover(true);
//			log.info("======fanoutQueue1收到消息失败,将此条消息返回给队列======");
//		}
//
//	}
//
//	@RabbitListener(queues = "fanoutQueue2")
//	public void receiveFanout2(Message message, Channel channel) {
//		String msg=new String(message.getBody());
//		try {
//			log.info("======重试次数:"+count++);
//			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//		    int i=1/0;
//		}catch (Exception e){
//			log.error("======fanoutQueue2消费者1消费消息失败======"+e.getMessage());
//			throw new RuntimeException(e);
//		}
//		log.info("======fanoutQueue2消费者1消费消息成功:"+ msg +"======");
//	}
//
//	//@RabbitListener(queues = "fanoutQueue2")
//	public void receiveFanout3(Message message, Channel channel) throws IOException {
//		String msg=new String(message.getBody());
//		try {
//			log.info("======fanoutQueue2消费者2收到消息成功:"+ msg +"======");
//			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//		}catch (Exception e){
//			channel.basicRecover(true);
//			//channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
//			log.info("======fanoutQueue2消费者2收到消息失败,将此条消息返回给队列======");
//		}
//	}
}
