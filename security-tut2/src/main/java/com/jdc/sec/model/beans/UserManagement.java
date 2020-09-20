package com.jdc.sec.model.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sec.model.entity.User;
import com.jdc.sec.model.interceptors.ErrorHandler;
import com.jdc.sec.model.service.UserService;

@Named
@RequestScoped
@RolesAllowed("Admin")
public class UserManagement {

	private User user;
	private List<User> list;
	
	@Inject
	private UserService service;
	
	@PostConstruct
	private void init() {
		user = new User();
		list = service.findAllWithoutMe();
	}
	
	@ErrorHandler
	public String create() {
		service.create(user);
		return "/admin/home?faces-redirect=true";
	}
	
	public List<User> getList() {
		return list;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
