package com.os.china.dao;

import com.os.china.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-16
 * @Version 1.0.0
 */
@Repository
public class PersonDao {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Resource(name = "stringRedisTemplate")
	private ValueOperations<String, String> valOpsStr;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Resource(name = "redisTemplate")
	private ValueOperations<Object, Object> valOps;

	public void stringRedisTemplateDemo(){
		valOpsStr.set("a", "AA");
	}

	public void save(Person person) {
		valOps.set(person.getId(), person);
	}

	public String getString(){
		return valOpsStr.get("a");
	}

	public Person getPerson(){
		return (Person) valOps.get("001");
	}
}
