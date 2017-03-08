package com.os.china.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-7
 * @Version 1.0.0
 */
@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg){
		if (principal.getName().equals("admin")) {
			//向用户发送消息
			messagingTemplate.convertAndSendToUser("feinik",
					"/point/notifications", principal.getName() + "-send:" + msg);
		} else {
			messagingTemplate.convertAndSendToUser("admin",
					"/point/notifications", principal.getName() + "-send:" + msg);
		}
	}
}
