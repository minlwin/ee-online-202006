package com.jdc.sale.service;

import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sale.SaleException;
import com.jdc.sale.entity.Product;
import com.jdc.sale.entity.Sales;
import com.jdc.sale.entity.SalesDetails;

@Stateless
@LocalBean
public class SaleService {
	
	@PersistenceContext
	private EntityManager em;

	public void checkOut(Sales sale, Map<Product, Integer> cart) {

		if(null == cart || cart.isEmpty()) {
			throw new SaleException("Please add product to Shopping Cart.");
		}
		
		em.persist(sale);
		
		for(Entry<Product, Integer> entry : cart.entrySet()) {
			
			SalesDetails d = new SalesDetails();
			d.setSales(sale);
			d.setProduct(entry.getKey());
			d.setQuentity(entry.getValue());
			
			em.persist(d);
		}
	}

}
