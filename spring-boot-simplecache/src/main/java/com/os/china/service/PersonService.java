package com.os.china.service;

import com.os.china.entiy.Person;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
public interface PersonService {
	public Person save(Person person);
	public void remove(Long id);
	public Person findOne(Person person);
}
