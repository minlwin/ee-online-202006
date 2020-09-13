package com.jdc.cdi.service;

import javax.enterprise.event.Observes;

import com.jdc.cdi.service.dto.Customer;

public class CustomerLogService {

	public void log(@Observes Customer c) {
		System.out.println("======= Customer Logger ======");
		System.out.println(c);
	}
}
