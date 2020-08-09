package com.jdc.students.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "ACCOUNT_TBL")
@NamedQuery(name = "Account.findByLoginId", query = "select a from Account a where a.loginId = :loginId")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(unique = true, nullable = false, name = "login_id")
	private String loginId;
	private String password;
	private String name;
	@Enumerated(STRING)
	private Role role;

	public enum Role {
		Office, Teacher
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
