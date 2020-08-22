package com.jdc.product.model.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.product.model.entity.Product;
import com.jdc.product.model.service.ProductService;

@Named
@RequestScoped
public class ProductEditBean {

	private Product product;
	
	@EJB
	private ProductService service;
	
	@PostConstruct
	private void init() {
		product = new Product();
	}
	
	public String save() {
		service.save(product);
		return "/views/products?faces-redirect=true";
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
}
