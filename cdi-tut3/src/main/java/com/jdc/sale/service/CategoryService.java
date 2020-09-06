package com.jdc.sale.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.sale.entity.Category;

@LocalBean
@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	public List<Category> getAll() {
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}
}
