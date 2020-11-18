package com.jdc.products.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
	public void upload(Part file) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line = null;
			
			while(null != (line = br.readLine())) {
				createItem(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		
		Item i = query.getSingleResult();
		
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
		
		Product p = query.getSingleResult();
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
		
		Brand b = query.getSingleResult();
		
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
		Category c = query.getSingleResult();
		
		if(null == c) {
			c = new Category();
			c.setName(string);
			em.persist(c);
		}

		return c;
	}


	public List<Item> search(int category, int brand, String product) {
		return null;
	}
}
