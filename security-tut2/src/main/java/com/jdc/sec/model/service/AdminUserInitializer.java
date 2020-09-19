package com.jdc.sec.model.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.jdc.sec.model.entity.User;
import com.jdc.sec.model.entity.User.Role;

@Startup
@Singleton
public class AdminUserInitializer {

	@Inject
	private UserService service;
	
	@PostConstruct
	private void init() {
		
		Long count = service.countUsers();
		
		if(count == 0) {
			User user = new User();
			user.setName("Admin User");
			user.setLoginId("admin");
			user.setPassword("Admin");
			user.setRole(Role.Admin);
			
			service.create(user);
		}
	}
}
