package com.jdc.update.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DailyInvoiceDTO {

	private LocalDate date;
	private long invoices;
	private long total;
	
	public DailyInvoiceDTO() {
	}

	public DailyInvoiceDTO(LocalDate date, long invoices, long total) {
		super();
		this.date = date;
		this.invoices = invoices;
		this.total = total;
		
		System.out.println("Long Constructor");
	}
	
	public DailyInvoiceDTO(LocalDate date, long invoices, int total) {
		super();
		this.date = date;
		this.invoices = invoices;
		this.total = total;
		System.out.println("Integer Constructor");
	}
}
