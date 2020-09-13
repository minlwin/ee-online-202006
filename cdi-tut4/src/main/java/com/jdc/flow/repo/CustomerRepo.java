package com.jdc.flow.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CustomerRepo {

	@Named
	@Produces
	private List<Customer> customers;
	
	@PostConstruct
	private void init() {
		customers = new ArrayList<>();
	}
	
	public void add(Customer cust) {
		customers.add(cust);
	}
}
