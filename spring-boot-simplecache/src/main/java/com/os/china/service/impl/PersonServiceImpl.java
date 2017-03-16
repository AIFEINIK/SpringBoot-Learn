package com.os.china.service.impl;

import com.os.china.entiy.Person;
import com.os.china.repository.PersonRepository;
import com.os.china.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	//每次新增或修改都会缓存
	@CachePut(value = "people", key = "#person.id")
	@Override
	public Person save(Person person) {
		Person savePerson = personRepository.save(person);
		System.out.println("为id,key为：" + person.getId() + "的数据做了缓存");
		return savePerson;
	}

	//删除指定缓存
	@Override
	@CacheEvict(value = "people")
	public void remove(Long id) {
		personRepository.delete(id);
		System.out.println("删除了id,key为：" + id + "的数据缓存");
	}

	//先从缓存中查询，如果没有的话，在从数据库中查询然后保存进缓存
	@Override
	@Cacheable(value = "people", key = "#person.id")
	public Person findOne(Person person) {
		Person one = personRepository.findOne(person.getId());
		System.out.println("为id,key为：" + person.getId() + "的数据做了缓存");
		return one;
	}
}
