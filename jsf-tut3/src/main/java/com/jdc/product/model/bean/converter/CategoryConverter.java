package com.jdc.product.model.bean.converter;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import com.jdc.product.model.entity.Category;
import com.jdc.product.model.service.CategoryService;

@Named
@Dependent
public class CategoryConverter implements Converter<Category>{
	
	@EJB
	private CategoryService service;

	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String value) {
			
		if(null != value && !value.isEmpty()) {
			int id = Integer.parseInt(value);
			return service.findById(id);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Category value) {
		
		if(null != value) {
			return String.valueOf(value.getId());
		}
		
		return null;
	}

}
