package com.jdc.job.search.entity;

import javax.persistence.Entity;

@Entity
public class Employer extends Member {

	private static final long serialVersionUID = 1L;

	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
