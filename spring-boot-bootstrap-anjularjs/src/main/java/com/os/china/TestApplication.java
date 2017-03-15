package com.os.china;

import com.os.china.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-10
 * @Version 1.0.0
 */
@RestController
@SpringBootApplication
public class TestApplication {

	@RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Person search(String personName) {
		return new Person(personName, 12, "beijing");
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
