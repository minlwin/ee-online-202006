package com.jdc.demo.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class CounterSessionBean implements CounterLocal, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int count;

	@Override
	public void countUp() {
		count ++;
	}

	@Override
	public int getCount() {
		return count;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Counter Bean is Initialized.");
	}

}
