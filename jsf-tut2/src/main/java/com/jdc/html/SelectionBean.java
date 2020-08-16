package com.jdc.html;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.html.SelectData.Gender;

@Named
@RequestScoped
public class SelectionBean {

	private SelectData data = new SelectData();
	
	private List<String> interestList = Arrays.asList("IT", "Musics", "Movies", "Books", "Sports");

	public SelectData getData() {
		return data;
	}

	public void setData(SelectData data) {
		this.data = data;
	}
	
	public List<String> getInterestList() {
		return interestList;
	}
	
	public Gender[] getGenders() {
		return Gender.values();
	}
}
