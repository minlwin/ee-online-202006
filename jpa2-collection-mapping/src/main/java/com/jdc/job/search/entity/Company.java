package com.jdc.job.search.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.JoinColumn;

@Entity
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;

	@ElementCollection
	@CollectionTable(name = "PHONES", joinColumns = @JoinColumn(name = "company"))
	private List<String> phones;
	
	@ElementCollection
	@MapKeyColumn(name = "name")
	@CollectionTable(name = "PROPERTIES", joinColumns = @JoinColumn(name = "company"))
	private Map<String, String> properties;
	
	@ElementCollection
	@MapKeyColumn(name = "location")
	@CollectionTable(joinColumns = @JoinColumn(name = "company"))
	private Map<String, Address> address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	
}
