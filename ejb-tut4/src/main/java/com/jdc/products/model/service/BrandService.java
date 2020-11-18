package com.jdc.products.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.products.model.entity.Brand;

@LocalBean
@Stateless
public class BrandService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Brand> findByCategory(int category) {
		TypedQuery<Brand> query = em.createNamedQuery("Brand.findByCategory", Brand.class);
		query.setParameter("category", category);
		return query.getResultList();
	}

}
