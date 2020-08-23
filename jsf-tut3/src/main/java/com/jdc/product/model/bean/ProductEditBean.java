package com.jdc.product.model.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.product.model.entity.Product;
import com.jdc.product.model.service.ProductService;

@Named
@RequestScoped
public class ProductEditBean {
	
	@Inject
	@ManagedProperty("#{param.id}")
	private int id;
	
	private Product product;
	
	@EJB
	private ProductService service;
	
	@PostConstruct
	private void init() {
		if(id == 0) {
			product = new Product();
		} else {
			product = service.findById(id);
		}
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
