package com.jdc.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jdc.demo.listener.TimeEnable;
import com.jdc.demo.listener.TimesListner;

import lombok.Data;

@Data
@Entity
@EntityListeners(TimesListner.class)
public class Booking implements TimeEnable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime issueDate;
	@Column(name = "date_from")
	private LocalDate from;
	@Column(name = "date_to")
	private LocalDate to;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Room room;

	private TimeInfo times;
}
