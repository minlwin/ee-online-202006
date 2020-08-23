package com.jdc.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.product.model.entity.Product;

@LocalBean
@Stateless
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	
	public List<Product> search(int categoryId, String productName) {
		
		StringBuffer sb = new StringBuffer("select p from Product p where 1 = 1");
		Map<String, Object> param = new HashMap<>();
		
		if(categoryId > 0) {
			sb.append(" and p.category.id = :cat");
			param.put("cat", categoryId);
		}
		
		if(null != productName && !productName.isEmpty()) {
			sb.append(" and lower(p.name) like lower(:name)");
			param.put("name", productName.concat("%"));
		}
		
		TypedQuery<Product> query = em.createQuery(sb.toString(), Product.class);
		for(String key : param.keySet()) {
			query.setParameter(key, param.get(key));
		}
		
		return query.getResultList();
	}

	public void save(Product product) {

		if(product.getId() == 0) {
			em.persist(product);
		} else {
			em.merge(product);
		}
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

}
