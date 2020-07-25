package com.jdc.students.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.students.model.entity.Classes;

public class ClassesService {

	private EntityManager em;

	public ClassesService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void create(Classes c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public List<Classes> getAll() {
		return em.createNamedQuery("Classes.getAll", Classes.class).getResultList();
	}

	public Classes findById(int id) {
		return em.find(Classes.class, id);
	}
}
