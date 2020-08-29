package com.jdc.life;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("myConverter")
public class MyConverter implements Converter<String>{

	@Override
	public String getAsObject(FacesContext context, UIComponent component, String value) {
		
		System.out.println("Convert To Object");
		System.out.println("Phase : " + context.getCurrentPhaseId().getName());
		System.out.println("====================================");
		
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, String value) {
		
		System.out.println("Convert To String");
		System.out.println("Phase : " + context.getCurrentPhaseId().getName());
		System.out.println("====================================");

		return value;
	}

}
