package com.jdc.convert.nrc;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@Dependent
public class NrcNumberFormatter implements Converter<NrcNumber>{

	@Override
	public NrcNumber getAsObject(FacesContext context, UIComponent component, String value) {
		// Nothing to do for a formatter
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, NrcNumber value) {
		
		if(null != value) {
			return String.format("%s / %s (%s) %06d", 
					value.getStateCode(), value.getCityCode(), value.getType(), value.getRegistNumber());
		}
		
		return null;
	}

}
