package com.jdc.demo.service;

import javax.ejb.Local;

@Local
public interface CounterLocal {

	void countUp();
	
	int getCount();
}
