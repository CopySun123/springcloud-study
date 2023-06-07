package com.copysun.rabbitmqprovider.controller;

import com.copysun.common.vo.ResultCode;
import com.copysun.common.vo.ResultVo;
import com.copysun.sdk.req.rabbitmqconsume.MessageReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author copysun
 * @Date: Create in 14:51 2023/5/10
 * @Desc
 */
@RestController
@Slf4j
public class MessageSendController {

	@Resource
	RabbitTemplate rabbitTemplate;

	@PostMapping("/sendTopic")
	@ResponseBody
	public ResultVo sendTopic(@RequestBody MessageReq messageReq){
		ResultVo resultVo;
		try {
			rabbitTemplate.convertAndSend("testTopicExchange",messageReq.getRoutingKey(),messageReq.getContent());
			resultVo=new ResultVo(ResultCode.SUCCESS);
		}catch (Exception e){
			resultVo=new ResultVo(ResultCode.FAILED);
		}
		return resultVo;
	}

	@PostMapping("/sendDirect")
	@ResponseBody
	public ResultVo sendDirect(@RequestBody MessageReq messageReq){
		ResultVo resultVo;
		try {
			rabbitTemplate.convertAndSend("testDirectExchange",messageReq.getRoutingKey(),messageReq.getContent());
			resultVo=new ResultVo(ResultCode.SUCCESS);
		}catch (Exception e){
			resultVo=new ResultVo(ResultCode.FAILED);
		}
		return resultVo;
	}

	@PostMapping("/sendFanout")
	@ResponseBody
	public ResultVo provide(@RequestBody MessageReq messageReq){
		ResultVo resultVo;
		try {
			rabbitTemplate.convertAndSend("testFanoutExchange","",messageReq.getContent(),new CorrelationData(UUID.randomUUID().toString()));
			resultVo=new ResultVo(ResultCode.SUCCESS);
		}catch (Exception e){
			resultVo=new ResultVo(ResultCode.FAILED);
		}
		return resultVo;
	}
}
