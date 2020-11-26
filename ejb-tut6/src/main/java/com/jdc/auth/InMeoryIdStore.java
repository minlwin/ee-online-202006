package com.jdc.auth;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class InMeoryIdStore implements IdentityStore {
	
	private List<User> users = List.of(
			new User("Admin", "Admin", "Admin"),
			new User("Member", "Member", "Member")
	);

	@Override
	public CredentialValidationResult validate(Credential credential) {
		
		UsernamePasswordCredential loginUser = (UsernamePasswordCredential) credential;
		
		for(User u : users) {
			if(loginUser.getCaller().equals(u.name) && loginUser.getPasswordAsString().equals(u.password)) {
				return new CredentialValidationResult(u.name, Set.of(u.role));
			}
		}
		
		return CredentialValidationResult.INVALID_RESULT;
	}
	
	private class User {
		String name;
		String password;
		String role;

		public User(String name, String password, String role) {
			super();
			this.name = name;
			this.password = password;
			this.role = role;
		}
		
	}
}
