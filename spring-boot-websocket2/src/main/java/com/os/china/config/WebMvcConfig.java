package com.os.china.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-7
 * @Version 1.0.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	/**
	 * MVC视图控制器配置
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//添加一个请求映射地址
		registry.addViewController("/ws").setViewName("/ws");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/chat").setViewName("/chat");
	}
}
