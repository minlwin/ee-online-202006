package com.jdc.online.jpa.entity;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@Table(name = "student_tbl")
@SequenceGenerator(name = "student_seq")
public class Student implements Serializable {

	public enum Gender {Male, Female}
	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "student_seq")
	private int id;
	
	@Temporal(DATE)
	@Column(nullable = false)
	private Date dateOfBirth;
	@Enumerated(STRING)	
	@Column(length = 10)
	private Gender gender;
	@Basic(optional = false)
	private String name;
	private String phone;
	private String email;
	
	@Transient
	private boolean selected;
	
	private SecurityInfo security;
	
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public SecurityInfo getSecurity() {
		return security;
	}
	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}
   
}
