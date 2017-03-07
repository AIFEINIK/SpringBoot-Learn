package com.os.china.controller;

import com.os.china.entity.SocketMessage;
import com.os.china.entity.SocketResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-7
 * @Version 1.0.0
 */
@Controller
public class WebSocketController {

	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//当浏览器向服务器端发送STOMP请求时，通过@MessageMapping注解来映射/getServerTime地址
	@MessageMapping(value = "/getServerTime")
	//当服务端有消息时，会对订阅了@SendTo中的路径的客户端发送消息
	@SendTo(value = "/topic/getResponse")
	public SocketResponse serverTime(SocketMessage message) throws InterruptedException {
		return new SocketResponse(message.getMessage() + sf.format(new Date()));
	}
}
