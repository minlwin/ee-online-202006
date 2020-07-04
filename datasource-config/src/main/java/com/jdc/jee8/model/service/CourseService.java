package com.jdc.jee8.model.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.jee8.model.entity.Course;

import java.util.List;

import javax.ejb.LocalBean;

@LocalBean
@Stateless
public class CourseService {

	@PersistenceContext
	private EntityManager em;

	public List<Course> getAll() {
		return em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	public Course save(Course course) {
		
		if(course.getId() == 0) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		
		return course;
	}

	public Course findById(int id) {
		return em.find(Course.class, id);
	}
}
