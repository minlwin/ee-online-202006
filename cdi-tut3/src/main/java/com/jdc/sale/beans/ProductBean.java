package com.jdc.sale.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sale.entity.Product;
import com.jdc.sale.service.ProductService;

@Named
@ViewScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> products;

	@Inject
	private ProductService service;
	
	@Inject
	@ManagedProperty("#{param.category}")
	private int category;

	@PostConstruct
	private void init() {
		int id = category == 0 ? 1 : category;
		products = service.findByCategory(id);
	}
	
	public List<Product> getProducts() {
		return products;
	}
}
