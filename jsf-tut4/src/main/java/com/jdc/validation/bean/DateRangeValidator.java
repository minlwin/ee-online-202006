package com.jdc.validation.bean;

import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("formDateRangeValidator")
public class DateRangeValidator implements Validator<LocalDate>{

	@Override
	public void validate(FacesContext context, UIComponent component, LocalDate dateTo) throws ValidatorException {

		UIInput inputFrom = (UIInput) context.getViewRoot().findComponent("form:dFrom");
		LocalDate dateFrom = (LocalDate) inputFrom.getLocalValue(); 
		
		if(null != dateFrom && null != dateTo) {
			if(dateFrom.compareTo(dateTo) > 0) {
				FacesMessage message = new FacesMessage("Date To must be greater than or equal to Date From.");
				context.addMessage("form:dTo", message);
			}
		}
	}

}
