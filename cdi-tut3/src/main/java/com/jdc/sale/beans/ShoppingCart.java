package com.jdc.sale.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.sale.entity.Product;
import com.jdc.sale.entity.SalesDetails;

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
	
	public int getTotal() {
		return cart.entrySet().stream()
				.mapToInt(e -> e.getKey().getPrice() * e.getValue())
				.sum();
	}
	
	public List<SalesDetails> getOrders() {
		return cart.entrySet().stream()
				.map(entry -> {
					SalesDetails d = new SalesDetails();
					d.setProduct(entry.getKey());
					d.setQuentity(entry.getValue());
					return d;
				}).collect(Collectors.toList());
	}

	public void add(Product p) {
		
		if(cart.containsKey(p)) {
			int count = cart.get(p);
			cart.put(p, count + 1);
		} else {
			cart.put(p, 1);
		}
	}

	public void clear() {
		cart.clear();
	}
}
