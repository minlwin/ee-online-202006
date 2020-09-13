package com.jdc.cdi.service.alternatives;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.jdc.cdi.service.CustomerService;
import com.jdc.cdi.service.dto.Customer;

@Alternative
public class CustomerServieceMoak implements CustomerService{
	
	@Inject
	private Event<Customer> creationEvent;

	@Override
	public void create(Customer c) {
		System.out.println(c);
		c.setId(1);
		
		creationEvent.fire(c);
	}

	@Override
	public List<Customer> search(String name) {
		System.out.println("Search name is " + name);
		
		Customer c = new Customer();
		c.setId(1);
		c.setName("Aung Aung");
		c.setPhone("09877789987");
		
		Customer c1 = new Customer();
		c1.setId(2);
		c1.setName("Maung Maung");
		c1.setPhone("09877789999");

		return Arrays.asList(c, c1);
	}

	@Override
	public Customer findById(int id) {
		Customer c = new Customer();
		c.setId(1);
		c.setName("Aung Aung");
		c.setPhone("09877789987");
		return c;
	}

}
