package com.jdc.back.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("one")
@RequestScoped
public class OneWayBean {

	private String state  = "Primary State";
	
	public String getState() {
		return state;
	}
	
	public String getOtherState() {
		return "Other State is " + state;
	}
	
	public String getTitle() {
		return "One Way Data Binding";
	}
	
	public String getTitleStyle() {
		return "color:red; font-wieght: bold";
	}
}
