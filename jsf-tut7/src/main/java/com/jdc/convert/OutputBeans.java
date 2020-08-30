package com.jdc.convert;

import java.time.LocalDate;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class OutputBeans {

	private long number = 10000;
	private State state = State.YES;
	private Date date = new Date();
	private LocalDate localDate = LocalDate.now();
	private User user;

	{
		user = new User();
		user.setName("Min Lwin");
		user.setPhone("09782003098");
	}

	public enum State {
		YES, NO, THANKS;
		
		@Override
		public String toString() {
			return String.format("This is %s!", name().toLowerCase());
		}
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
