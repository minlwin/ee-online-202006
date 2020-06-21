package com.jdc.online.jpa.entity;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;

@Entity
@IdClass(RegistrationId.class)
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Temporal(DATE)
	private Date registionDate;
	@Id
	private int studentId;
	private int fees;
	private int paid;

	public Date getRegistionDate() {
		return registionDate;
	}

	public void setRegistionDate(Date registionDate) {
		this.registionDate = registionDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

}
