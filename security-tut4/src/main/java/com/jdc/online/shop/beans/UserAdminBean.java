package com.jdc.online.shop.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.service.MemberService;

@Named("userAdmin")
@RequestScoped
public class UserAdminBean {

	private String role;
	private String name;
	private String email;
	
	private List<Member> users;
	
	@Inject
	private MemberService service;
	
	public void search() {
		users  = service.search(role, name, email);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Member> getUsers() {
		return users;
	}
	
	
}
