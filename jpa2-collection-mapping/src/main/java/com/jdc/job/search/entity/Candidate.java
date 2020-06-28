package com.jdc.job.search.entity;

import javax.persistence.Entity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.AttributeOverrides;

@Entity
public class Candidate extends Member{

	private static final long serialVersionUID = 1L;

	private String education;
	
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name ="add_street")),
		@AttributeOverride(name = "address", column = @Column(name ="add_address")),
		@AttributeOverride(name = "township", column = @Column(name ="add_township"))
	})
	private Address address;
	
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "con_street")),
		@AttributeOverride(name = "address", column = @Column(name = "con_address")),
		@AttributeOverride(name = "township", column = @Column(name = "con_township")) 
	})
	private Address contact;

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getContact() {
		return contact;
	}

	public void setContact(Address contact) {
		this.contact = contact;
	}
	
	
	
}
