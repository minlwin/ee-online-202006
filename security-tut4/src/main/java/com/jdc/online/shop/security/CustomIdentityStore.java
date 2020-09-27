package com.jdc.online.shop.security;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.online.shop.ShopAppException;
import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.service.MemberService;

@ApplicationScoped
public class CustomIdentityStore implements IdentityStore{

	@Inject
	private Pbkdf2PasswordHash encrypt;
	
	@Inject
	private MemberService service;
	
	@Inject
	private Event<Member> event;
	
	@Override
	public CredentialValidationResult validate(Credential credential) {
		
		UsernamePasswordCredential userNameAndPasssword = (UsernamePasswordCredential) credential;
		
		Member member = service.findByEmail(userNameAndPasssword.getCaller());
		
		// member not found
		if(null == member) {
			throw new ShopAppException("There is no user with this email address.");
		}
		
		// deleted member
		if(member.isDeleted()) {
			throw new ShopAppException("Invalid member. Please contact to admin.");
		}
		
		
		// password
		if(!encrypt.verify(userNameAndPasssword.getPasswordAsString().toCharArray(), 
				member.getPassword())) {
			throw new ShopAppException("Invalid password. Please check your password.");
		}
		
		event.fire(member);
		
		return new CredentialValidationResult(member.getEmail(), 
				Set.of(member.getRole().name()));
	}
}
