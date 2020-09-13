package com.jdc.cdi.service;

import java.util.List;

import com.jdc.cdi.service.dto.Customer;

public interface CustomerService {

	void create(Customer c);
	
	List<Customer> search(String name);
	
	Customer findById(int id);
}
