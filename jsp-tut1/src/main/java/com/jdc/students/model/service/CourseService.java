package com.jdc.students.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jdc.students.model.entity.Course;

public class CourseService {

	private EntityManager em;

	public CourseService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void create(Course c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public List<Course> getAll() {
		return em.createNamedQuery("Course.getAll", Course.class).getResultList();
	}

	public Course findById(int id) {
		return em.find(Course.class, id);
	}
}
