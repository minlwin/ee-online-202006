package com.jdc.life;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationBean {

	private String name;
	private int age;
	
	public String send() {
		return "navigate-to";
	}
	
	public String redirect() {
		return "navigate-to?faces-redirect=true";
	}
	
	public void redirectByExternalContext() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("navigate-to.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
