package com.jdc.jetty.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Post.findAll", query = "select p from Post p")
public class Post {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String message;
}
