package com.os.china.controller;

import com.os.china.dao.PersonDao;
import com.os.china.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-17
 * @Version 1.0.0
 */
@RestController
public class RedisController {

	@Autowired
	private PersonDao personDao;

	@RequestMapping("/set")
	public void set(){
		Person person = new Person("001", "Array", 22);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}

	@RequestMapping("/getStr")
	public String getStr(){
		return personDao.getString();
	}

	@RequestMapping("/getPerson")
	public Person getPerson(){
		return personDao.getPerson();
	}
}
