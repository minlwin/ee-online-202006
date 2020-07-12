package com.jdc.update.service.dto;

import com.jdc.update.entity.Township;

import lombok.Data;

@Data
public class TownshipDTO {

	private int id;
	private String name;
	private String division;
	
	public TownshipDTO() {
	}

	public TownshipDTO(int id, String name, String division) {
		super();
		this.id = id;
		this.name = name;
		this.division = division;
	}
	
	public TownshipDTO(Township t) {
		this.id = t.getId();
		this.name = t.getName();
		this.division = t.getDivision().getName();
	}
	
}
