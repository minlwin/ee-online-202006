package com.jdc.life;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("myValidator")
public class MyValidator implements Validator<String>{

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		
		System.out.println("Validate Input Value");
		System.out.println("Phase : " + context.getCurrentPhaseId().getName());
		System.out.println("====================================");
	}

}
