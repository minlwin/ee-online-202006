package com.jdc.back.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ActionDemoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	
	private List<String> list = new ArrayList<>();
	
	public void add() {
		list.add(message);
		message = null;
	}
	
	public void remove(String str) {
		list.remove(str);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getList() {
		return list;
	}

	
}
