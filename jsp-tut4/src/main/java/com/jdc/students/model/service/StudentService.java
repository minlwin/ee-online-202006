package com.jdc.students.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.students.model.entity.Student;

@Stateless
@LocalBean
public class StudentService {

	@PersistenceContext
	private EntityManager em;

	public List<Student> search(String name, String phone) {
		
		StringBuffer sb = new StringBuffer("select s from Student s where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(!StringUtils.isEmpty(name)) {
			sb.append(" and lower(s.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(!StringUtils.isEmpty(phone)) {
			sb.append(" and lower(s.phone) like lower(:phone)");
			params.put("phone", phone.concat("%"));
		}
		
		TypedQuery<Student> query = em.createQuery(sb.toString(), Student.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public Student findById(String str) {
		return em.find(Student.class, Integer.parseInt(str));
	}

	public void update(String id, String name, String phone, String email) {

		Student s = em.find(Student.class, Integer.parseInt(id));
		
		if(null != s) {
			s.setName(name);
			s.setPhone(phone);
			s.setEmail(email);
		}
	}
}
