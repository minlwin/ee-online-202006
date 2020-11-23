package com.jdc.products.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import com.jdc.products.model.entity.Brand;
import com.jdc.products.model.entity.Category;
import com.jdc.products.model.entity.Item;
import com.jdc.products.model.entity.Product;


@LocalBean
@Stateless
public class ProductService {
	
	@PersistenceContext
	private EntityManager em;

	@Asynchronous
	public Future<Boolean> upload(Part file) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line = null;
			
			while(null != (line = br.readLine())) {
				createItem(line);
			}
			
			return new AsyncResult<Boolean>(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<Boolean>(false);
		
	}
	


	private void createItem(String line) {
		
		String [] array = line.split("\t");
		if(array.length == 6) {
			
			// category
			Category c = findCategory(array[0]);
			
			// brand
			Brand b = findBrand(c, array[1]);
			
			// product
			Product p = findProduct(b, array[2]);
			
			// item
			Item item = findItem(p, array[3]);
			item.setPrice(Integer.parseInt(array[4]));
			item.setAgentPrice(Integer.parseInt(array[5]));
		}
	}

	private Item findItem(Product p, String string) {
		
		TypedQuery<Item> query = em.createNamedQuery("Item.findByProductAndName", Item.class);
		query.setParameter("product", p.getId());
		query.setParameter("name", string);
		
		Item i = getSingleResult(query);
		
		if(null == i) {
			i = new Item();
			i.setProduct(p);
			i.setName(string);
			em.persist(i);
		}
		
		return i;
	}



	private Product findProduct(Brand b, String string) {
		
		TypedQuery<Product> query  = em.createNamedQuery("Product.findByBrandAndName", Product.class);
		query.setParameter("brand", b.getId());
		query.setParameter("name", string);
		
		Product p = getSingleResult(query);
		if(null == p) {
			p = new Product();
			p.setBrand(b);
			p.setName(string);
			em.persist(p);
		}
		
		return p;
	}

	private Brand findBrand(Category c, String string) {
		
		TypedQuery<Brand> query = em.createNamedQuery("Brand.findByCategoryAndName", Brand.class);
		query.setParameter("category", c.getId());
		query.setParameter("name", string);
		
		Brand b = getSingleResult(query);
		
		if(null == b) {
			b = new Brand();
			b.setCategory(c);
			b.setName(string);
			em.persist(b);
		}
		
		return b;
	}

	private Category findCategory(String string) {
		
		TypedQuery<Category> query = em.createNamedQuery("Category.findByName", Category.class);
		query.setParameter("name", string);		
		Category c = getSingleResult(query);
		
		if(null == c) {
			c = new Category();
			c.setName(string);
			em.persist(c);
		}

		return c;
	}
	
	private<T> T getSingleResult(TypedQuery<T> query) {
		
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("No Entity");
		}
		
		return null;
	}


	public List<Item> search(int category, int brand, String product) {
		
		StringBuffer sb = new StringBuffer("select i from Item i where 1 = 1");
		Map<String, Object> params  = new HashMap<>();
		
		if(category > 0) {
			sb.append(" and i.product.brand.category.id = :categoryId");
			params.put("categoryId", category);
		}
		
		if(brand > 0) {
			sb.append(" and i.product.brand.id = :brandId");
			params.put("brandId", brand);
		}
		
		if(null  != product && !product.isBlank()) {
			sb.append(" and i.product.name like :product");
			params.put("product", product.concat("%"));
		}
		
		TypedQuery<Item> query = em.createQuery(sb.toString(), Item.class);
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}
}
