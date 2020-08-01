package com.jdc.shopping.model.service;

import javax.persistence.EntityManager;

public class SaleService {

	private EntityManager em;

	public SaleService(EntityManager em) {
		super();
		this.em = em;
	}
	
	
}
