package com.jdc.shopping.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.shopping.model.entity.Sale;

public class SaleService {

	private EntityManager em;
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public SaleService(EntityManager em) {
		super();
		this.em = em;
	}

	public void save(Sale sale) {

		em.getTransaction().begin();
		sale.setSaleDate(LocalDateTime.now());
		
		if(sale.getId() == 0) {
			em.persist(sale);
		} else {
			em.merge(sale);
		}
		em.getTransaction().commit();
	}

	public List<Sale> search(String from, String to) {
		
		StringBuffer sb = new StringBuffer("select s from Sale s where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != from && !from.isEmpty()) {
			
			sb.append(" and s.saleDate >= :from");
			LocalDate dateFrom = LocalDate.parse(from, DF);
			params.put("from", dateFrom.atStartOfDay());
		}
		
		if(null != to && !to.isEmpty()) {
			sb.append(" and s.saleDate < :to");
			LocalDate dateTo = LocalDate.parse(to, DF).plusDays(1);
			params.put("to", dateTo.atStartOfDay());
		}
		
		TypedQuery<Sale> query = em.createQuery(sb.toString(), Sale.class);
		
		for(Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return query.getResultList();
	}

	public Sale findById(String id) {
		return em.find(Sale.class, Integer.parseInt(id));
	}
	
	
}
