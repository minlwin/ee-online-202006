package com.jdc.students.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.students.model.entity.Registration;

public class RegistrationService {

	private EntityManager em;

	public RegistrationService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void create(Registration r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}
	
	public List<Registration> getAll() {
		return em.createNamedQuery("Registration.getAll", Registration.class).getResultList();
	}
}
