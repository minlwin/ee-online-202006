package com.jdc.shopping.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String customer;
	private LocalDateTime saleDate;
	
	@OneToMany(mappedBy = "sale", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<SaleDetails> details = new ArrayList<>();
}
