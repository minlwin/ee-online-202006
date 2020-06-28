package com.jdc.relationship.entiity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	@OneToOne
	private Address address;
	
	@OneToMany
	@OrderBy("name")
	private List<Course> courses;
	
	@ManyToMany(mappedBy = "students")
	private List<ClassRoom> classes;
}
