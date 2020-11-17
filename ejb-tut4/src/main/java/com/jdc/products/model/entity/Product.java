package com.jdc.products.model.entity;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String image;
	private Brand brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
