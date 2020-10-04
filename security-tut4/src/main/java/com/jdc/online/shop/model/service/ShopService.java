package com.jdc.online.shop.model.service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.entity.Member.Role;
import com.jdc.online.shop.model.entity.Shop;

@Local
@Stateless
public class ShopService {

	@PersistenceContext
	private EntityManager em;
	@Inject
	private MemberService members;
	
	public void create(Shop shop) {
		
		// create owner
		Member owner = shop.getOwner();
		owner.setRole(Role.Owner);
		
		members.create(owner);
		
		// create shop
		em.persist(shop);
		
	}
}
