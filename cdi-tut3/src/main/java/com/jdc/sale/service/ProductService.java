package com.jdc.sale.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sale.entity.Product;

@LocalBean
@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	
	public List<Product> findByCategory(int id) {
		return em.createNamedQuery("Product.findByCategory", Product.class)
				.setParameter("categoryId", id).getResultList();
	}

}
