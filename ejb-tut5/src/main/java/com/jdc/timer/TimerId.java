package com.jdc.timer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TimerId implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private LocalDateTime creation;
	private int interval;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	

}
