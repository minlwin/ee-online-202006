package com.jdc.validation.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class DateRangeValidationBean {

	private SearchDTO dto;

	@PostConstruct
	private void init() {
		dto = new SearchDTO();
	}

	public void save() {
		System.out.println(dto);
	}

	public SearchDTO getDto() {
		return dto;
	}

	public void setDto(SearchDTO dto) {
		this.dto = dto;
	}
	
	public void checkPrices(FacesContext context, UIComponent component, Object toValue) {
		
		UIInput pFrom = (UIInput) context.getViewRoot().findComponent("form:pFrom");
		Object fromValue = pFrom.getLocalValue();
		
		if(null != fromValue && null != toValue) {
			Integer from = (Integer) fromValue;
			Integer to = (Integer) toValue;
			
			if(from > to) {
				FacesMessage message = new FacesMessage("Price To must be greater than or equal to Price From.");
				context.addMessage("form:pTo", message);
			}
		}
	}

}
