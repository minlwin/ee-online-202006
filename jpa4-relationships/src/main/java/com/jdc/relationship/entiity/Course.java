package com.jdc.relationship.entiity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	private double duration;
	private int fees;
}
