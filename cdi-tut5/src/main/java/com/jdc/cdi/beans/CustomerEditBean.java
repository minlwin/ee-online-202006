package com.jdc.cdi.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.cdi.service.CustomerService;
import com.jdc.cdi.service.dto.Customer;

@Named
@RequestScoped
public class CustomerEditBean {

	private Customer cust;
	
	@Inject
	private CustomerService service;
	
	@Inject
	@ManagedProperty("#{param.id}")
	private int id;
	
	@PostConstruct
	private void init() {
		cust = (id == 0) ? new Customer() : service.findById(id);
	}
	
	public String save() {
		
		service.create(cust);
		
		return "/details?faces-redirect=true&id=" + cust.getId();
	}
	
	public Customer getCust() {
		return cust;
	}
	
	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
