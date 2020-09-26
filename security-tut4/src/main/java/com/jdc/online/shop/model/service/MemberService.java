package com.jdc.online.shop.model.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.online.shop.ShopAppException;
import com.jdc.online.shop.model.entity.Member;

@LocalBean
@Stateless
public class MemberService {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private Pbkdf2PasswordHash encrypt;
	
	public void create(Member member) {
		
		// check user by email
		Long count = em.createNamedQuery("Member.findCountByEmail", Long.class)
				.setParameter("email", member.getEmail())
				.getSingleResult();
		
		if(count > 0) {
			// there is member with same email with new member
			throw new ShopAppException("Your email has already registered.");
		}
		
		// encrypt password
		member.setPassword(encrypt.generate(member.getPassword().toCharArray()));
		
		em.persist(member);
	}

	public Long findCount() {
		return em.createNamedQuery("Member.findCount", Long.class).getSingleResult();
	}

	public Member findByEmail(String email) {
		
		TypedQuery<Member> query = em.createNamedQuery("Member.findByEmail", Member.class);
		query.setParameter("email", email);
		
		List<Member> list = query.getResultList();
		
		for(Member m  : list) {
			return m;
		}

		return null;
	}
}
