package com.jdc.online.shop.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.entity.Shop;
import com.jdc.online.shop.model.service.ShopService;

@Named
@SessionScoped
public class OwnerShopBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Named("loginUser")
	@Inject
	private Member owner;
	
	private Shop shop;
	@Inject
	private ShopService service;
	
	@PostConstruct
	private void init() {
		shop  = service.findByOnwer(owner);
	}
	
	public void saveShopInfo() {
		shop = service.save(shop);
	}
	
	public void changeState() {
		shop.setPublished(!shop.isPublished());
		shop = service.save(shop);
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
}
