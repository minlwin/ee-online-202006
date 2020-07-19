package com.jdc.counter;

import java.io.Serializable;

public class Counter implements Serializable{

	private static final long serialVersionUID = 1L;

	private int count;
	
	public void countUp() {
		count ++;
	}
	
	public int getCount() {
		return count;
	}
}
