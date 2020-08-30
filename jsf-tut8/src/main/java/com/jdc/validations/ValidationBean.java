package com.jdc.validations;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidationBean {

	private int priceFrom;
	private int priceTo;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String password;
	private String email;
	private String phone;
	
	public void check() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		// prices
		if(priceFrom > priceTo) {
			FacesMessage message = new FacesMessage("Price from must be less than price to.");
			context.addMessage(null, message);
			context.validationFailed();
		}
		
		// dates
		if(null != dateFrom && null != dateTo && dateFrom.compareTo(dateTo) > 0) {
			FacesMessage message = new FacesMessage("Date from must be aerlier than Date to.");
			context.addMessage(null, message);
			context.validationFailed();
		}
		
	}
	
	public String send() {
		
		if(FacesContext.getCurrentInstance().isValidationFailed()) {
			return null;
		}
		
		return "output";
	}

	public int getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(int priceFrom) {
		this.priceFrom = priceFrom;
	}

	public int getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(int priceTo) {
		this.priceTo = priceTo;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
