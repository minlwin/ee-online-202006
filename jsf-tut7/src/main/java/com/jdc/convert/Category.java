package com.jdc.convert;

public class Category {

	private int id;
	private String name;
	
	private static int counter;
	
	public Category() {
		id = counter ++;
	}
	
	public Category(String name) {
		this();
		this.name = name;
	}

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

}
