package com.os.china.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangPengFei
 * @Discription 演示banner的自定义显示与关闭
 * @Data 2017-2-18
 * @Version 1.0.0
 */
@SpringBootApplication
public class SetBanner {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SetBanner.class);
		// 关闭spring-boot启动时banner的日志打印
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
