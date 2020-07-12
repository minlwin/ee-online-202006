package com.jdc.update.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity
@Data
@NamedQuery(name = "Invoice.searchDailyInvoices",
		query = "select new com.jdc.update.service.dto.DailyInvoiceDTO(i.invoiceDate, count(i), sum(i.paidAmount)) from Invoice i group by i.invoiceDate having i.invoiceDate = :date order by i.invoiceDate")
@NamedQuery(name = "Invoice.searchMaxInvoice", query = "select i from Invoice i where i.paidAmount = (select max(iv.paidAmount) from Invoice iv)")
@NamedQuery(name = "Invoice.searchByTownships", query = "select i from Invoice i where i.paidDate = :date and i.customer.address.township.name in :townships") 
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@ManyToOne
	private Customer customer;
	@Column(name = "paid_amount")
	private int paidAmount;
	@Column(name = "invoice_date")
	private LocalDate invoiceDate;
	@Column(name = "paid_date")
	private LocalDate paidDate;
}
