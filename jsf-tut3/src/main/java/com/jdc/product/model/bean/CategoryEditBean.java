package com.jdc.product.model.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.jdc.product.model.entity.Category;
import com.jdc.product.model.service.CategoryService;

@Named
@RequestScoped
public class CategoryEditBean {

	private Category category;
	
	@EJB
	private CategoryService service;
	
	@PostConstruct
	private void init() {
		
		String strId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		if(null != strId) {
			int id = Integer.parseInt(strId);
			category = service.findById(id);
		} else {
			category = new Category();
		}
		
	}
	
	public String save() {
		// save category to database
		service.save(category);
		// redirect to category list
		return "/views/categories?faces-redirect=true";
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
}
