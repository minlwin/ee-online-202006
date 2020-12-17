package com.jdc.ee.librian.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.ee.librian.entity.Category;
import com.jdc.ee.librian.service.CategoryService;

@Named
@RequestScoped
public class CategoryBean {

	private List<Category> list;
	
	@EJB
	private CategoryService service;
	
	@PostConstruct
	private void init() {
		list = service.getAll();
	}
	
	public List<Category> getList() {
		return list;
	}
}
