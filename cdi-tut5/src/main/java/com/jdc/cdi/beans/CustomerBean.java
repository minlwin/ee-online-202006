package com.jdc.cdi.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import com.jdc.cdi.service.CustomerService;
import com.jdc.cdi.service.dto.Customer;

@Named
@RequestScoped
//@Interceptors({
//	ConstructorInvocationLogger.class
//})
public class CustomerBean {

	private String name;
	private List<Customer> list;
	
	@Inject
	private CustomerService service;
	
	public CustomerBean() {
		System.out.println("Within Constructor");
	}
	
	@PostConstruct
	private void init() {
		System.out.println("Post Construct");
	}
	
	@Custom
	public void search() {
		list = service.search(name);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Customer> getList() {
		return list;
	}
		
}
