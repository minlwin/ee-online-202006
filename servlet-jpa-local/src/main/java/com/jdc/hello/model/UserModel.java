package com.jdc.hello.model;

import java.util.List;

import javax.persistence.EntityManager;

public class UserModel {

	private EntityManager em;

	public UserModel(EntityManager em) {
		super();
		this.em = em;
	}
	
	public List<Users> findAll() {
		return em.createNamedQuery("Users.findAll", Users.class).getResultList();
	}
	
	public void close() {
		if(null != em && em.isOpen()) {
			em.close();
		}
	}

	public void save(Users user) {

		em.getTransaction().begin();
		
		if(user.getId() == 0) {
			em.persist(user);
		} else  {
			em.merge(user);
		}
		
		em.getTransaction().commit();
	}
}
