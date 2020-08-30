package com.jdc.convert;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@Dependent
public class UserConverter implements Converter<User>{

	@Override
	public User getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, User value) {
		if(null != value) {
			return String.format("%s (%s)", value.getName(), value.getPhone());
		}
		return null;
	}

}
