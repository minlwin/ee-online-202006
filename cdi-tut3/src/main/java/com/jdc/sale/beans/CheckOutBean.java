package com.jdc.sale.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sale.entity.Sales;
import com.jdc.sale.service.SaleService;

@Named
@ConversationScoped
public class CheckOutBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Sales sale;
	
	@Inject
	private SaleService service;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private ShoppingCart cart;
	
	@PostConstruct
	private void init() {
		sale = new Sales();
		
		if(conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String checkOut() {
		
		service.checkOut(sale, cart.getOrders());
		cart.clear();
		
		if(!conversation.isTransient()) {
			conversation.end();
		}
		return "/views/sales?faces-redirect=true";
	}

	public Sales getSale() {
		return sale;
	}

	public void setSale(Sales sale) {
		this.sale = sale;
	}

	
}
