package com.jdc.sec.model.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.sec.model.entity.User;
import com.jdc.sec.model.entity.User.Role;
import com.jdc.sec.model.interceptors.ErrorHandler;
import com.jdc.sec.model.service.UserService;

@Named
@RequestScoped
public class SignUpBean {

	private User member;
	
	@Inject
	private UserService service;
	
	@PostConstruct
	private void init() {
		member = new User();
		member.setRole(Role.Member);
	}

	@ErrorHandler
	public String signUp() {
		service.create(member);
		return "member/home.xhtml?faces-redirect=true";
	}
	
	public User getMember() {
		return member;
	}
	
	public void setMember(User member) {
		this.member = member;
	}
}
