package com.jdc.sale.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.sale.entity.Product;

@Named
@SessionScoped
public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<Product, Integer> cart;
	
	@PostConstruct
	private void init() {
		cart = new LinkedHashMap<>();
	}
	
	public Map<Product, Integer> getCart() {
		return cart;
	}
	
	@Named("cartCount")
	@Produces
	public int getCartCount() {
		return cart.values().stream()
				.mapToInt(a -> a)
				.sum();
	}

	public void add(Product p) {
		
		if(cart.containsKey(p)) {
			int count = cart.get(p);
			cart.put(p, count + 1);
		} else {
			cart.put(p, 1);
		}
	}
}
