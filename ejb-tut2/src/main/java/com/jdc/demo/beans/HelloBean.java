package com.jdc.demo.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jdc.demo.service.CounterLocal;
import com.jdc.demo.service.FirstSingleton;
import com.jdc.demo.service.HelloRemote;

@Named
@ViewScoped
public class HelloBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private HelloRemote helloEjb;
	
	@EJB
	private CounterLocal counter;
	
	@EJB
	private FirstSingleton first;
	
	public void countUp() {
		counter.countUp();
	}
	
	public String getSingletonMessage() {
		return first.getMessage();
	}
	
	public String getCount() {
		return String.format("Count : %d", counter.getCount());
	}
	
	public String getMessage() {
		return helloEjb.sayHello();
	}
}
