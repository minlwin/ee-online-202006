package com.jdc.shopping.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.shopping.model.entity.Category;
import com.jdc.shopping.model.entity.Product;

public class ProductService {

	private EntityManager em;

	public ProductService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void save(Product p) {
		
		em.getTransaction().begin();
		
		if(p.getId() == 0) {
			em.persist(p);
		} else {
			em.merge(p);
		}
		
		em.getTransaction().commit();
		
	}
	
	public List<Product> search(String categoryId, String name) {
		
		StringBuffer sb = new StringBuffer("select p from Product p where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != categoryId && !categoryId.isEmpty() && !"0".equals(categoryId)) {
			sb.append(" and p.category.id = :categorId");
			params.put("categorId", Integer.parseInt(categoryId));
		}
		
		if(null != name && !name.isEmpty()) {
			sb.append(" and lower(p.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		TypedQuery<Product> query = em.createQuery(sb.toString(), Product.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public void saveAll(List<String> list) {
		
		em.getTransaction().begin();
		
		for(String line : list) {
			Product p = getProductFromLine(line);
			em.persist(p);
		}
		
		em.getTransaction().commit();
		
	}

	private Product getProductFromLine(String line) {
		Product p = new Product();
		
		String [] array = line.split("\t");
		Category c = findCategoryByName(array[0]);
		p.setCategory(c);
		p.setName(array[1]);
		p.setPrice(Integer.parseInt(array[2]));
		
		return p;
	}

	private Category findCategoryByName(String name) {
		TypedQuery<Category> query = em.createNamedQuery("Category.findByName", Category.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
}
