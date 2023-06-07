package com.copysun.nacosdemo.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @Author copysun
 * @Date: Create in 10:04 2023/5/8
 * @Desc
 */
@Configuration
@Slf4j
public class WebSocketConfig extends ServerEndpointConfig.Configurator {

	/**
	 * 拦截
	 * @param sec
	 * @param request
	 * @param response
	 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		log.info("======websocket拦截器处理开始======");
		HttpSession session= (HttpSession) request.getHttpSession();
		if(!ObjectUtils.isEmpty(session)){
			//进行处理
		}
		log.info("======websocket拦截器处理完成======");
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}

}
