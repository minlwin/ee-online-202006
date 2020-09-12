package com.jdc.sale.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sale.entity.Sales;
import com.jdc.sale.service.SaleService;

@Named
@RequestScoped
public class SaleDetailsBean {

	private Sales sales;
	
	@Inject
	@ManagedProperty("#{param.id}")
	private int saleId;
	
	@Inject
	private SaleService service;
	
	@PostConstruct
	private void init() {
		sales = service.findById(saleId);
	}
	
	public Sales getSales() {
		return sales;
	}
}
