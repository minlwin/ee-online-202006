package com.jdc.flow;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.flow.repo.Customer;
import com.jdc.flow.repo.CustomerRepo;

@Named
@FlowScoped("registration")
public class RegistrationBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Customer customer;
	
	@PostConstruct
	private void init() {
		customer = new Customer();
	}
	
	@Inject
	private CustomerRepo repo;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String save() {
		repo.add(customer);
		return "/index";
	}
	
}
