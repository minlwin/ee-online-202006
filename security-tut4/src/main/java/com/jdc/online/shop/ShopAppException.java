package com.jdc.online.shop;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ShopAppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShopAppException(String message) {
		super(message);
	}
	
}
