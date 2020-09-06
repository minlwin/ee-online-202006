package com.jdc.sale.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sale.entity.Category;
import com.jdc.sale.service.CategoryService;

@ApplicationScoped
public class CategoriesBeans {

	@Inject
	private CategoryService service;
	
	@Named
	@Produces
	private List<Category> categories;
	
	@PostConstruct
	private void init() {
		this.categories = service.getAll();
		System.out.println("Init Application Scope for Categories");
	}

}
