package com.jdc.sec.model.service;

import java.security.Principal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.sec.AppCommonException;
import com.jdc.sec.model.entity.User;

@LocalBean
@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Pbkdf2PasswordHash passwordEncoder;
	
	@Inject
	private Principal principal;
	
	public void create(User user) {
		
		User old = em.find(User.class, user.getLoginId());
		if(null != old) {
			throw new AppCommonException("Member is already exists with " + user.getLoginId());
		}
		
		user.setPassword(passwordEncoder.generate(user.getPassword().toCharArray()));
		em.persist(user);
	}

	public Long countUsers() {
		return em.createNamedQuery("User.count", Long.class).getSingleResult();
	}

	public void changePassword(String password, String newPwassword, String confirmPassword) {
		
		User user = em.find(User.class, principal.getName());
		
		if(password.equals(newPwassword)) {
			throw new AppCommonException("Old password and new password are same.");
		}
		
		// password
		if(!passwordEncoder.verify(password.toCharArray(), user.getPassword())) {
			throw new AppCommonException("Invalid password");
		}
		
		if(!newPwassword.equals(confirmPassword)) {
			throw new AppCommonException("New Password and Confirm Password must be same.");
		}
		
		user.setPassword(passwordEncoder.generate(newPwassword.toCharArray()));
	}

	public List<User> findAllWithoutMe() {
		
		TypedQuery<User> query = em.createNamedQuery("User.findAllWithoutMe", User.class);
		query.setParameter("loginId", principal.getName());
		return query.getResultList();
	}
}
