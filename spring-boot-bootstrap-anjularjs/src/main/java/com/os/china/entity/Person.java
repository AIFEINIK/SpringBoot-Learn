package com.os.china.entity;

/**
 * @author ZhangPengFei
 * @Discription
 * @Data 2017-3-10
 * @Version 1.0.0
 */
public class Person {
	private String name;
	private int age;
	private String address;

	public Person() {
	}

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
