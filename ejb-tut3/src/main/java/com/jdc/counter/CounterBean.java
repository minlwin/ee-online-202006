package com.jdc.counter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CounterBean {

	@EJB
	private Counter counter;
	
	public void countUp() {
		counter.countUp();
	}
	
	public int getCount() {
		return counter.getCount();
	}
}
