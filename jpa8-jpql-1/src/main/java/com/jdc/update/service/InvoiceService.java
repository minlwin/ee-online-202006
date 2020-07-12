package com.jdc.update.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.update.entity.Invoice;
import com.jdc.update.service.dto.DailyInvoiceDTO;
import com.jdc.update.service.dto.DailyInvoiceSummary;

public class InvoiceService {

	private EntityManager em;

	public InvoiceService(EntityManager em) {
		super();
		this.em = em;
	}

	public int getAverage(LocalDate date) {
		
		String jpql = "select AVG(i.paidAmount) from Invoice i where i.invoiceDate  = :date";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("date", date);
		return getInteger(query.getSingleResult());
	}
	
	public int getTotal(LocalDate date) {
		String jpql = "select SUM(i.paidAmount) from Invoice i where i.invoiceDate  = :date";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("date", date);
		return getInteger(query.getSingleResult());
	}
	
	public int getMaxForDay(LocalDate date) {
		String jpql = "select MAX(i.paidAmount) from Invoice i where i.invoiceDate  = :date";
		TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
		query.setParameter("date", date);
		return getInteger(query.getSingleResult());
	}

	public int getMinForDay(LocalDate date) {
		String jpql = "select MIN(i.paidAmount) from Invoice i where i.invoiceDate  = :date";
		TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
		query.setParameter("date", date);
		return getInteger(query.getSingleResult());
	}
		
	public List<Invoice> searchByInvoiceDate(LocalDate from, LocalDate to) {
		
		String jpql = "select i from Invoice i where i.invoiceDate between :from and :to";
		TypedQuery<Invoice> query = em.createQuery(jpql, Invoice.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		
		return query.getResultList();
	}
	
	public List<Invoice> searchByTownships(List<String> townships, LocalDate paidDate) {
		
		TypedQuery<Invoice> query = em.createNamedQuery("Invoice.searchByTownships", Invoice.class);
		query.setParameter("date", paidDate);
		query.setParameter("townships", townships);
		return query.getResultList();
	}
	
	public List<Invoice> searchMaxInvoice() {
		TypedQuery<Invoice> query = em.createNamedQuery("Invoice.searchMaxInvoice", Invoice.class);
		return query.getResultList();
	}
	
	public List<DailyInvoiceDTO> searchDailyInvoices(LocalDate date) {
		TypedQuery<DailyInvoiceDTO> query = em.createNamedQuery("Invoice.searchDailyInvoices", DailyInvoiceDTO.class);
		query.setParameter("date", date);
		return query.getResultList();
	}

	public List<DailyInvoiceSummary> getSummary(LocalDate from, LocalDate to) {
		TypedQuery<DailyInvoiceSummary> query = em.createNamedQuery("Invoice.getSummary", DailyInvoiceSummary.class);
		query.setParameter("from", from);
		query.setParameter("to", to);
		return query.getResultList();
	}
	

	private int getInteger(Integer d) {
		
		if(null == d) {
			return 0;
		}
		
		return d;
	}

	private int getInteger(Double d) {
		
		if(null == d) {
			return 0;
		}
		
		return Math.round(d.floatValue());
	}

	private int getInteger(Long value) {
		if(null == value) {
			return 0;
		}
		return value.intValue();
	}
	
}
