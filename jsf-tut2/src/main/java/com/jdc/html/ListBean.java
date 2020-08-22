package com.jdc.html;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ListBean {

	private List<Student> list;
	
	@PostConstruct
	private void init() {
		list = new ArrayList<>();
		list.add(new Student("Aung Aung", "0977678964", "aung@gmail.com", "Kamayut, Yangon"));
		list.add(new Student("Maung Maung", "0977678963", "maung@gmail.com", "Insein, Yangon"));
		list.add(new Student("Maung Ba", "0977678962", "mgba@gmail.com", "Hlaing, Yangon"));
	}
	
	public List<Student> getList() {
		return list;
	}
}
