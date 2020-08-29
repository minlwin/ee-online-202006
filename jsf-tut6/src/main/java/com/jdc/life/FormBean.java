package com.jdc.life;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class FormBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String message;
	private List<String> list = new ArrayList<>();
	
	public void add() {
		
		System.out.println("Invoke Action Method");
		System.out.println("Phase : " + FacesContext.getCurrentInstance().getCurrentPhaseId().getName());
		System.out.println("====================================");

		list.add(message);
		message = "";
	}
	
	public List<String> getList() {
		return list;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
