package com.jdc.students.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.students.model.entity.Course;
import com.jdc.students.model.entity.Registration;
import com.jdc.students.model.entity.Student;

@Stateless
@LocalBean
public class RegistrationService {

	@PersistenceContext
	private EntityManager em;

	public void create(String course, String applyDate, Student student) {

		Course c = em.find(Course.class, Integer.parseInt(course));
		Registration r = new Registration();
		r.setCourse(c);
		r.setStudent(student);
		r.setApplyDate(LocalDate.parse(applyDate, DateTimeFormatter.ISO_DATE));
		
		em.persist(r);
	}

	public List<Registration> search(String courseId, String student, String from, String to) {
		
		StringBuffer sb = new StringBuffer("select r from Registration r where 1 = 1");
		Map<String, Object> params = new  HashMap<>();
		
		if(!StringUtils.isEmpty(courseId) && !"0".equals(courseId)) {
			sb.append(" and r.course.id = :course");
			params.put("course", Integer.parseInt(courseId));
		}
		
		if(!StringUtils.isEmpty(student)) {
			sb.append(" and lower(r.student.name) like lower(:student)");
			params.put("student", student.concat("%"));
		}
		
		if(!StringUtils.isEmpty(from)) {
			sb.append(" and r.applyDate >= :from");
			params.put("from", LocalDate.parse(from, DateTimeFormatter.ISO_DATE));
		}
		
		if(!StringUtils.isEmpty(to)) {
			sb.append(" and r.applyDate <= :to");
			params.put("to", LocalDate.parse(to, DateTimeFormatter.ISO_DATE));
		}
		
		TypedQuery<Registration> query = em.createQuery(sb.toString(), Registration.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}
}
