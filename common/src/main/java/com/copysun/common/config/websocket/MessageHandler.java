package com.copysun.common.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author copysun
 * @Date: Create in 10:07 2023/5/8
 * @Desc websocket消息处理类
 */
@Component
@ServerEndpoint(value = "/websocket",configurator = WebSocketConfig.class)
@Slf4j
public class MessageHandler {

	/**
	 * 用来存放连接的用户
	 */
	private static final ConcurrentHashMap<String, Session> sessions=new ConcurrentHashMap<>();

	/**
	 * 开启连接
	 * @param session
	 */
	@OnOpen
	public void opOpen(Session session){
		sessions.put("测试名",session);
		log.info("======用户1登录成功======");
	}

	/**
	 * 关闭连接
	 * @param session
	 */
	@OnClose
	public void onClose(Session session){
		sessions.remove("测试名");
		log.info("======用户1退出登录======");
	}

	@OnMessage
	public void onMessage(String message,Session session){
		log.info("======收到客户端消息:+"+message+"======");
	}

	/**
	 * 指定用户发送消息
	 * @param userId
	 * @param message
	 */
	public boolean sendMessageToUser(String userId,String message){
		Session session = sessions.get(userId);
		if(ObjectUtils.isEmpty(session)){
			log.info("======用户:"+userId+"未登录======");
			return false;
		}
		if(!session.isOpen()){
			return false;
		}
		try {
			session.getBasicRemote().sendText("测试发送消息");
			log.info("======用户:"+userId+"发送消息成功!"+message);
			return true;
		} catch (Exception e) {
			log.error("======用户:"+userId+"发送消息失败!"+e.getMessage());
		}
		return false;
	}

	/**
	 * 给所有用户发送消息
	 * @param message
	 */
	public boolean sendMessageToAll(String message){
		sessions.forEach((userId,session)->{
			try {
				session.getBasicRemote().sendText(message);
				log.info("======用户:"+userId+"发送消息成功!"+message);
			} catch (Exception e) {
				log.error("======用户:"+userId+"发送消息失败!"+e.getMessage());
			}
		});
		return true;
	}


	/**
	 * 从websocket中的session取出用户名
	 * @param session
	 * @return
	 */
	private String getUserName(Session session){
		return null;
	}
}
