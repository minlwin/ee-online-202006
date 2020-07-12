package com.jdc.update.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DailyInvoiceSummary {

	private LocalDate invoiceDate;
	private Integer total;
	private Double aveage;
	private Integer min;
	private Integer max;
	
	public DailyInvoiceSummary(LocalDate invoiceDate, Integer total, Double aveage, Integer min, Integer max) {
		super();
		this.invoiceDate = invoiceDate;
		this.total = total;
		this.aveage = aveage;
		this.min = min;
		this.max = max;
	}
	
	
}
