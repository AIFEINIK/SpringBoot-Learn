package com.os.china.domain.entity;

import com.os.china.domain.AbstractEntity;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription
 * @Data 2017-3-24
 * @Version 1.0.0
 */
public class Person extends AbstractEntity {

	private Integer id;

	private String username;

	private Integer age;

	private String address;

	public Person() {
		super();
	}

	public Person(String username, Integer age, String address) {
		this.username = username;
		this.age = age;
		this.address = address;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
