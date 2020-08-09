package com.jdc.students.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.students.model.entity.Course;

@Stateless
@LocalBean
public class CourseService {

	@PersistenceContext
	private EntityManager em;

	public List<Course> getAll() {
		return em.createNamedQuery("Course.getAll", Course.class).getResultList();
	}

	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	public void save(Course c) {
		if(c.getId() == 0) {
			em.persist(c);
		} else {
			em.merge(c);
		}
	}
	
}
