package com.jdc.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String>{

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

		if(null != value && !value.isEmpty()) {
			
			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			
			if(!matcher.find()) {
				FacesMessage message = new FacesMessage("Please enter valid email address.");
				context.addMessage(null, message);
			}
		}
	}

}
