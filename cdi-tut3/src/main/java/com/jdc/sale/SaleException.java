package com.jdc.sale;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class SaleException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SaleException(String message) {
		super(message);
	}
}
