package com.jdc.online.shop.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Property implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
