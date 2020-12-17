package com.jdc.ee.librian.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jdc.ee.librian.entity.Category;
import com.jdc.ee.librian.service.CategoryService;

@Named
@ViewScoped
public class CategoryEditBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Category category;
	
	@EJB
	private CategoryService service;
	
	@PostConstruct
	private void init() {
		category = new Category();
	}
	
	public String save() {
		service.save(category);
		return "/views/categories?faces-redirect=true";
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
