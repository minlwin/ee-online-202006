package com.jdc.product.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.product.model.entity.Product;
import com.jdc.product.model.service.ProductService;

@Named
@RequestScoped
public class ProductBean {

	private int categoryId;
	private String productName;
	
	private List<Product> list;
	
	@EJB
	private ProductService service;
	
	@PostConstruct
	private void init() {
		list = new ArrayList<>();
	}
	
	public void search() {
		list = service.search(categoryId, productName);
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<Product> getList() {
		return list;
	}

}
