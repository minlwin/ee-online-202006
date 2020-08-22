package com.jdc.product.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.product.model.entity.Category;

@LocalBean
@Stateless
public class CategoryService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Category> getAll() {
		return em.createNamedQuery("Category.getAll", Category.class).getResultList();
	}

	public void save(Category category) {
		
		if(category.getId() == 0) {
			em.persist(category);
		} else {
			em.merge(category);
		}
		
	}

	public Category findById(int id) {
		return em.find(Category.class, id);
	}

}
