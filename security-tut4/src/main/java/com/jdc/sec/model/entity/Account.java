package com.jdc.sec.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message = "Please enter login id.")
	private String loginId;
	@NotEmpty(message = "Please enter password.")
	private String password;
	@NotEmpty(message = "Please enter user name.")
	private String name;
	@NotNull(message = "Please select Role.")
	private Role role;
	private boolean deleted;

	public enum Role {
		Admin, Member;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
