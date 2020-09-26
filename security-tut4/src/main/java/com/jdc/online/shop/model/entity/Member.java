package com.jdc.online.shop.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@NamedQuery(name = "Member.findCount", 
	query = "select count(m) from Member m")
@NamedQuery(name = "Member.findCountByEmail", 
	query = "select count(m) from Member m where m.email = :email")
@NamedQuery(name = "Member.findByEmail", 
	query = "select m from Member m where m.email = :email")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Email(message = "Please enter valid email.")
	@Column(nullable = false, unique = true)
	private String email;
	@NotEmpty(message = "Please enter name.")
	private String name;
	@NotEmpty(message = "Please enter password.")
	private String password;
	private boolean deleted;
	private Role role;

	public enum Role {
		Admin, Owner, Custoner
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
