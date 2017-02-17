package com.os.china.helloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-2-17
 * @Version 1.0.0
 */
@RestController
/**开启自动配置的核心注解**/
@SpringBootApplication
public class HelloWord {

	@RequestMapping(value = "/")
	public String index(){
		return "Hello spring-boot";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWord.class, args);
	}
}
