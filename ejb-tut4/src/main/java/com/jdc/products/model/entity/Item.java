package com.jdc.products.model.entity;

public class Item {

	private int id;
	private Product product;
	private String name;
	private int price;
	private int agentPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAgentPrice() {
		return agentPrice;
	}

	public void setAgentPrice(int agentPrice) {
		this.agentPrice = agentPrice;
	}

}
