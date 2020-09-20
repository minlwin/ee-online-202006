package com.jdc.sec.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "account")
@NamedQuery(name = "User.findAllWithoutMe", query = "select u from User u where u.loginId <> :loginId")
@NamedQuery(name = "User.count", query = "select count(u) from User u")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "login_id")
	@NotEmpty(message = "Please enter login Id.")
	private String loginId;
	@NotEmpty(message = "Please enter Member name.")
	private String name;
	@NotEmpty(message = "Please enter Password.")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public enum Role {
		Admin, Member
	}
}
