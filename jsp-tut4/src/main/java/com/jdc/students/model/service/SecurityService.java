package com.jdc.students.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.students.model.StudentRegistrationException;
import com.jdc.students.model.entity.Account;

@Stateless
@LocalBean
public class SecurityService {

	@PersistenceContext
	private EntityManager em;

	public Account login(String loginId, String password) {
		
		Account account = null;
		
		List<Account> list = em.createNamedQuery("Account.findByLoginId", Account.class)
				.setParameter("loginId", loginId).getResultList();
		
		if(!list.isEmpty()) {
			account = list.get(0);
		}
		
		if(null == account) {
			throw new StudentRegistrationException("Please check your login id.");
		}
		
		if(!account.getPassword().equals(password)) {
			throw new StudentRegistrationException("Please check your password.");
		}
		
		return account;
	}
}
