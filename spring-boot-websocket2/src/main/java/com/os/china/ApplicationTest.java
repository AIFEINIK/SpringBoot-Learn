package com.os.china;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-7
 * @Version 1.0.0
 */
@SpringBootApplication
public class ApplicationTest {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ApplicationTest.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
