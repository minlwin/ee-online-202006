package com.jdc.online.shop.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	/**
	 * Create Shop by Owner at first time
	 * 
	 * @param shop
	 */
	public void create(Shop shop) {
		
		// create owner
		Member owner = shop.getOwner();
		owner.setRole(Role.Owner);
		
		members.create(owner);
		
		// create shop
		em.persist(shop);
		
	}

	/**
	 * Search Shop by Admin
	 * 
	 * @param shopName
	 * @param owner
	 * @param keywords
	 * @return
	 */
	public List<Shop> search(String shopName, String owner, String keywords) {
		
		StringBuffer sb = new StringBuffer("select s from Shop s where 1 = 1");
		Map<String, String> params = new HashMap<>();
		
		if(null != shopName && !shopName.isEmpty()) {
			sb.append(" and lower(s.name) like lower(:name)");
			params.put("name", shopName.concat("%"));
		}
		
		if(null != owner && !owner.isEmpty()) {
			sb.append(" and lower(s.owner.name) like lower(:owner)");
			params.put("owner", owner.concat("%"));
		}

		if(null != keywords && !keywords.isEmpty()) {
			sb.append(" and lower(s.type) like lower(:type)");
			params.put("type", "%".concat(keywords).concat("%"));
		}
		
		TypedQuery<Shop> query = em.createQuery(sb.toString(), Shop.class);
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}

	/**
	 * Fine One Shop by their Owner
	 * 
	 * @param owner
	 * @return
	 */
	public Shop findByOnwer(Member owner) {
		TypedQuery<Shop> query = em.createNamedQuery("Shop.findByOwner", Shop.class);
		query.setParameter("loginId", owner.getEmail());
		return query.getSingleResult();
	}

	public Shop save(Shop shop) {
		return em.merge(shop);
	}
}
