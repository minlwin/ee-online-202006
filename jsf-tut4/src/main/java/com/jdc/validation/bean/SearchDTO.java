package com.jdc.validation.bean;

import java.time.LocalDate;

public class SearchDTO {

	private int priceFrom;
	private int priceTo;

	private LocalDate dateFrom;
	private LocalDate dateTo;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(int priceFrom) {
		this.priceFrom = priceFrom;
	}

	public int getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(int priceTo) {
		this.priceTo = priceTo;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	@Override
	public String toString() {
		return "SearchDTO [priceFrom=" + priceFrom + ", priceTo=" + priceTo + ", dateFrom=" + dateFrom + ", dateTo="
				+ dateTo + ", name=" + name + "]";
	}
	

}
