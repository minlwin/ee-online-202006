package com.jdc.sale.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sale.entity.Sales;
import com.jdc.sale.service.SaleService;

@Named
@RequestScoped
public class SalesHistoryBean {

	private List<Sales> list;
	
	@Inject
	private SaleService service;
	
	@PostConstruct
	private void init() {
		list = service.getAll();
	}
	
	public List<Sales> getList() {
		return list;
	}
	
	public int getTotal() {
		return list.stream().mapToInt(s -> s.getTotal()).sum();
	}
	
	public int getQuentity() {
		return list.stream().mapToInt(s -> s.getQuentity()).sum();
	}
}
