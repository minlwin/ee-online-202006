package com.jdc.online.shop.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import com.jdc.online.shop.ShopAppException;
import com.jdc.online.shop.model.entity.Product;
import com.jdc.online.shop.model.entity.Shop;

@LocalBean
@Stateless
public class ProductSearvice {

	@PersistenceContext
	private EntityManager em;

	public List<Product> search(Shop shop, String name, int priceFrom, int priceTo) {
		
		if(priceFrom > priceTo) {
			throw new ShopAppException("Invalid inputs! Price To must be greater than Price From.");
		}
		
		StringBuffer sb = new StringBuffer("select p from Product p where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != shop) {
			sb.append(" and p.shop.id = :shopId");
			params.put("shopId", shop.getId());
		}
		
		if(null != name && !name.isBlank()) {
			sb.append(" and lower(p.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		if(priceFrom > 0) {
			sb.append(" and p.price >= :from");
			params.put("from", priceFrom);
		}
		
		if(priceTo > 0) {
			sb.append(" and p.price <= :to");
			params.put("to", priceTo);
		}
		
		TypedQuery<Product> query = em.createQuery(sb.toString(), Product.class);
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public void upload(Shop shop, Part file) {

		if(null != shop && null != file) {
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				
				String line = null;
				
				while(null != (line = br.readLine())) {
					String [] array = line.split("\t");
					Product product = new Product();
					product.setShop(shop);
					product.setName(array[0]);
					product.setPrice(Integer.parseInt(array[2]));
					product.setUsed(!"1".equals(array[1]));
					
					em.persist(product);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
}
