package com.os.china;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableCaching //开启缓存
public class RunApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunApplication.class, args);
	}
}
