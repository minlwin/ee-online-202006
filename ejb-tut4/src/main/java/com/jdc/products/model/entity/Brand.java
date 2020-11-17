package com.jdc.products.model.entity;

import java.io.Serializable;

public class Brand implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Category category;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
