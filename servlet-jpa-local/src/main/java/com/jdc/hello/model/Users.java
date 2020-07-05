package com.jdc.hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Users.findAll", query = "select u from Users u")
public class Users {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phone;
}
