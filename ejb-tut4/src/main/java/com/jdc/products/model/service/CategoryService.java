package com.jdc.products.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.products.model.entity.Category;

@LocalBean
@Stateless
public class CategoryService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Category> findAll() {
		return em.createNamedQuery("Category.findAll", Category.class).getResultList();
	}

}
