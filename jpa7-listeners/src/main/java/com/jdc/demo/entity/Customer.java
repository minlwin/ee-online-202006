package com.jdc.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
@Entity
// @ExcludeDefaultListeners
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	@PrePersist
	public void prePersist() {
		createAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateAt = LocalDateTime.now();
	}
}
