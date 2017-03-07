package com.os.china.entity;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-7
 * @Version 1.0.0
 */
public class SocketResponse {
	private String responseMessage;

	public SocketResponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
