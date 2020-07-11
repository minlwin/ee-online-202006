package com.jdc.update.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.update.entity.Customer;

public class CustomerService {

	private EntityManager em;

	public CustomerService(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Customer> findAll() {
		String jpql = "select c from Customer c";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		return query.getResultList();
	}

	public List<Customer> findByTownshipName(String string) {
		String jpql = "select c from Customer c where c.address.township.name = :name";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
		query.setParameter("name", string);
		return query.getResultList();
	}

}
