package com.jdc.online.shop.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.online.shop.ShopAppException;
import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.entity.Member.Role;

@LocalBean
@Stateless
public class MemberService {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private Pbkdf2PasswordHash encrypt;
	
	/**
	 * Create New Member
	 * @param member
	 */
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

	/**
	 * Find All User Count
	 * @return
	 */
	public Long findCount() {
		return em.createNamedQuery("Member.findCount", Long.class).getSingleResult();
	}

	/**
	 * Find One User By Email
	 * @param email
	 * @return
	 */
	public Member findByEmail(String email) {
		
		TypedQuery<Member> query = em.createNamedQuery("Member.findByEmail", Member.class);
		query.setParameter("email", email);
		
		List<Member> list = query.getResultList();
		
		for(Member m  : list) {
			return m;
		}

		return null;
	}

	/**
	 * Search Users by Admin User
	 * 
	 * @param role
	 * @param name
	 * @param email
	 * @return
	 */
	public List<Member> search(String role, String name, String email) {
		
		StringBuffer sb = new StringBuffer("select m from Member m where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != role && !role.isEmpty()) {
			sb.append(" and m.role = :role");
			params.put("role", Role.valueOf(role));
		}
		
		if(null != name && !name.isEmpty()) {
			sb.append(" and lower(m.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}

		if(null != email && !email.isEmpty()) {
			sb.append(" and lower(m.email) like lower(:email)");
			params.put("email", email.concat("%"));
		}
		
		TypedQuery<Member> query = em.createQuery(sb.toString(), Member.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}
}
