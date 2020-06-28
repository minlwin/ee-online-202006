package com.jdc.relationship.entiity;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import javax.persistence.JoinTable;

@Entity
@Data
@Table(name = "class")
public class ClassRoom implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@ManyToOne
	private Course course;
	@ElementCollection
	@CollectionTable(name = "class_days", joinColumns = @JoinColumn(name ="class_id"))
	private List<DayOfWeek> days;
	private LocalDate startDate;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	@ManyToMany
	@JoinTable(name = "registration", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;
}
