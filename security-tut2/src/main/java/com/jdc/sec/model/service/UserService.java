package com.jdc.sec.model.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.sec.model.entity.User;

@LocalBean
@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Pbkdf2PasswordHash passwordEncoder;
	
	public void create(User user) {
		user.setPassword(passwordEncoder.generate(user.getPassword().toCharArray()));
		System.out.println(user.getPassword());
		em.persist(user);
	}

	public Long countUsers() {
		return em.createNamedQuery("User.count", Long.class).getSingleResult();
	}
}
