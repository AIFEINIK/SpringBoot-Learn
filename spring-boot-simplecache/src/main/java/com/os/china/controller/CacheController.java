package com.os.china.controller;

import com.os.china.entiy.Person;
import com.os.china.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
@RestController
public class CacheController {
	@Autowired
	private PersonService personService;

	@RequestMapping("/put")
	public Person put(Person person){
		Person p = personService.save(person);
		return p;
	}

	@RequestMapping("/cacheAble")
	public Person able(Person person){
		Person p = personService.findOne(person);
		return p;
	}

	@RequestMapping("/cacheEvit")
	public String evit(Long id){
		personService.remove(id);
		return "ok";
	}

}
