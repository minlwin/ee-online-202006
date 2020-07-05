package com.jdc.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class TimeInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
