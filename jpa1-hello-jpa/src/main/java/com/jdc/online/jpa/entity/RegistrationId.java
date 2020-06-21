package com.jdc.online.jpa.entity;

import java.io.Serializable;
import java.util.Date;

public class RegistrationId implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date registionDate;
	private int studentId;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registionDate == null) ? 0 : registionDate.hashCode());
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationId other = (RegistrationId) obj;
		if (registionDate == null) {
			if (other.registionDate != null)
				return false;
		} else if (!registionDate.equals(other.registionDate))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	
}
