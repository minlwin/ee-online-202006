package com.jdc.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jdc.convert.OutputBeans.State;

@FacesConverter("stateConverter")
public class TypeConverter implements Converter<State>{

	@Override
	public State getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, State value) {
		
		if(null != value) {
			return value.toString();
		}
		
		return null;
	}

}
