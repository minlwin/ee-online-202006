package com.jdc.products.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.jdc.products.model.entity.Brand;
import com.jdc.products.model.entity.Category;
import com.jdc.products.model.entity.Item;
import com.jdc.products.model.service.BrandService;
import com.jdc.products.model.service.CategoryService;
import com.jdc.products.model.service.ProductService;

@Named
@ViewScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int category;
	private int brand;
	private String product;
	
	private List<Item> list;
	
	private List<Category> categories;
	private List<Brand> brands;
	
	private Part file;

	@EJB
	private ProductService service;
	@EJB
	private CategoryService catService;
	@EJB
	private BrandService brandService;
	
	@PostConstruct
	private void init() {
		categories = catService.findAll();
	}
	
	public void search() {
		list = service.search(category, brand, product);
	}
	
	public void upload() {
		
	}
	
	public void changeCategory() {
		brand = 0;
		if(category > 0) {
			brands = brandService.findByCategory(category);
		}
	}
	

	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public int getBrand() {
		return brand;
	}


	public void setBrand(int brand) {
		this.brand = brand;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public List<Item> getList() {
		return list;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
}
