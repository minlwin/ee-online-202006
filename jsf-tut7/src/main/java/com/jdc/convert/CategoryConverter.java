package com.jdc.convert;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class CategoryConverter implements Converter<Category> {

	@Inject
	private List<Category> categories;

	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(null != value && !value.isEmpty()) {
			int id = Integer.parseInt(value);
			
			for(Category  c : categories) {
				if(c.getId() == id) {
					return c;
				}
			}
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
