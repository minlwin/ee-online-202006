package com.jdc.online.shop.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.online.shop.model.entity.Shop;
import com.jdc.online.shop.model.service.ShopService;

@Named("shopAdmin")
@RequestScoped
public class ShopAdminBean {

	// search inputs
	private String shopName;
	private String owner;
	private String keywords;
	
	@Inject
	private ShopService service;

	// result for table
	private List<Shop> shops;
	
	public void search() {
		shops = service.search(shopName, owner, keywords);
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Shop> getShops() {
		return shops;
	}

}
