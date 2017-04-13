package com.os.china.exception;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 仓储自定义错误类
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public class RepositoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public RepositoryException(Exception e) {
		super(e);
	}

	public RepositoryException(String msg) {
		super(msg);
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
