package com.jdc.online.shop.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.jdc.online.shop.model.entity.Product;
import com.jdc.online.shop.model.service.ProductSearvice;

@Named
@ViewScoped
public class OwnerProducts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private OwnerShopBean ownerShop;

	private String name;
	private int priceFrom;
	private int priceTo;

	private Part file;

	private List<Product> list;
	
	@Inject
	private ProductSearvice service;
	
	@PostConstruct
	private void init() {
		search();
	}
	
	/**
	 * Upload Product
	 */
	public void upload() {
		service.upload(ownerShop.getShop(), file);
	}
	
	/**
	 * Search
	 */
	public void search() {
		list = service.search(ownerShop.getShop(), name, priceFrom, priceTo);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(int priceFrom) {
		this.priceFrom = priceFrom;
	}

	public int getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(int priceTo) {
		this.priceTo = priceTo;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public List<Product> getList() {
		return list;
	}

}
