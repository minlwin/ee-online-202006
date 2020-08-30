package com.jdc.life;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationBean {

	private String name;
	private int age;
	
	public String send() {
		return "navigate-to";
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
	
	public String getMessage() {
		return String.format("%s is %d years old.", name, age);
	}

}
