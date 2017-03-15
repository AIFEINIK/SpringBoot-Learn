package com.os.china;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-14
 * @Version 1.0.0
 */
@Entity
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer age;
	private String address;

	public Person() {
	}

	public Person(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
