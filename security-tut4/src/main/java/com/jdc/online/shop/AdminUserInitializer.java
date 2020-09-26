package com.jdc.online.shop;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.entity.Member.Role;
import com.jdc.online.shop.model.service.MemberService;

@Startup
@Singleton
public class AdminUserInitializer {

	@Inject
	private MemberService service;
	
	@PostConstruct
	private void init() {
		
		Long count = service.findCount();
		
		// there is no user
		if(count == 0) {
			Member member = new Member();
			member.setEmail("admin@jdc.com");
			member.setPassword("admin");
			member.setName("Admin User");
			member.setRole(Role.Admin);
			
			service.create(member);
		}
	}
}
