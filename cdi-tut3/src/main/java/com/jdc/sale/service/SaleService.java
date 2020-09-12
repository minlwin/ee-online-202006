package com.jdc.sale.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sale.SaleException;
import com.jdc.sale.entity.Sales;
import com.jdc.sale.entity.SalesDetails;

@Stateless
@LocalBean
public class SaleService {
	
	@PersistenceContext
	private EntityManager em;

	public void checkOut(Sales sale, List<SalesDetails> orders) {

		if(null == orders || orders.isEmpty()) {
			throw new SaleException("Please add product to Shopping Cart.");
		}
		
		em.persist(sale);
		
		for(SalesDetails d : orders) {
			d.setSales(sale);
			em.persist(d);
		}
	}

	public List<Sales> getAll() {
		return em.createNamedQuery("Sales.getAll", Sales.class).getResultList();
	}

	public Sales findById(int saleId) {
		return em.find(Sales.class, saleId);
	}

}
