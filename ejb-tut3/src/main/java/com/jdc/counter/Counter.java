package com.jdc.counter;

import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@AccessTimeout(value = 20, unit = TimeUnit.SECONDS)
public class Counter {

	private int count;
	
	@Lock(LockType.READ)
	public void countUp() {
		count ++;
		System.out.printf("Count : %d%n", count);
	}
	
	@Lock(LockType.READ)
	public int getCount() {
		return count;
	}
}
