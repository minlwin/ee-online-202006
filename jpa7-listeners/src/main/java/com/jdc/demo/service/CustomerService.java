package com.jdc.demo.service;

import javax.persistence.EntityManager;

import com.jdc.demo.entity.Customer;

public class CustomerService {

	private EntityManager em;
	
	public CustomerService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}

	public void save(Customer cust) {
		em.getTransaction().begin();
		
		if(cust.getId() == 0) {
			em.persist(cust);
		} else {
			em.merge(cust);
		}
		
		em.getTransaction().commit();
	}
}
