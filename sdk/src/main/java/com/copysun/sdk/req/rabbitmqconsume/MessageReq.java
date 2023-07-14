package com.copysun.sdk.req.rabbitmqconsume;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author copysun
 * @Date: Create in 16:21 2023/5/10
 * @Desc
 */
@Data
public class MessageReq implements Serializable {

	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 路由key
	 */
	private String routingKey;
}
