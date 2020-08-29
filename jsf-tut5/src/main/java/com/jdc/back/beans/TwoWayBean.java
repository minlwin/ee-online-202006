package com.jdc.back.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("two")
@RequestScoped
public class TwoWayBean {

	private String name;
	private int age;

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

}
