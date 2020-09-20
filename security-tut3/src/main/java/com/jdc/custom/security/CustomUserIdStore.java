package com.jdc.custom.security;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class CustomUserIdStore implements IdentityStore{
	
	private List<User> users;
	
	@PostConstruct
	private void init() {
		users = List.of(
			new User("Admin", "admin", "Admin"),
			new User("Memmber", "member", "Member")
		);
	}

	@Override
	public CredentialValidationResult validate(Credential credential) {
		
		UsernamePasswordCredential userNamePassword = (UsernamePasswordCredential) credential;
		
		for(User user : users) {
			if(userNamePassword.compareTo(user.name, user.pass)) {
				return new CredentialValidationResult(user.name, Set.of(user.role));
			}
		}
		
		return CredentialValidationResult.INVALID_RESULT;
	}
	
	
	private class User {
		String name;
		String pass;
		String role;

		User(String name, String pass, String role) {
			super();
			this.name = name;
			this.pass = pass;
			this.role = role;
		}
	}
}
