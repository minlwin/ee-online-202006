package com.jdc.students.model;

import java.util.List;

import javax.persistence.EntityManager;

public class StudentModel {

	private EntityManager em;

	public StudentModel(EntityManager em) {
		super();
		this.em = em;
	}

	public void save(Student s) {

		em.getTransaction().begin();
		
		if(s.getId() == 0) {
			em.persist(s);
		} else {
			em.merge(s);
		}
		
		em.getTransaction().commit();
	}

	public List<Student> findAll() {
		return em.createNamedQuery("Student.findAll", Student.class).getResultList();
	}
	
	
}
