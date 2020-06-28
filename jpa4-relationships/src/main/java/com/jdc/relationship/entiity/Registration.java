package com.jdc.relationship.entiity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "registration")
public class Registration implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegistrationPK id;
	
	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student;
	@ManyToOne
	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	private ClassRoom classRoom;
	private LocalDate registDate;
	private int paid;
}
