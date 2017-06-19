package com.os.china.rest.service;

import com.os.china.domain.entity.Person;
import com.os.china.rest.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

	/**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
	 * unless 表示条件表达式成立的话不放入缓存
     * @param username
     * @return
     */
    @Cacheable(value = "user", key = "#root.targetClass + #username", unless = "#result eq null")
    public Person getPersonByName(String username) {
        Person person = personRepo.getPersonByName(username);
        return person;
    }

	/**
	 * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     * @param person
     * @return
     */
    @CachePut(value = "user", key = "#root.targetClass + #result.username", unless = "#person eq null")
    public Person savePerson(Person person) {
        return personRepo.savePerson(person);
    }

	/**
	 * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     * @param username
     * @return
     */
    @CacheEvict(value = "user", key = "#root.targetClass + #username", condition = "#result eq true")
    public boolean removePersonByName(String username) {
        return personRepo.removePersonByName(username) > 0;
    }

    public boolean isExistPersonName(Person person) {
        return personRepo.existPersonName(person) > 0;
    }
}
