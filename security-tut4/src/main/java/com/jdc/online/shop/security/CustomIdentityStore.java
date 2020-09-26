package com.jdc.online.shop.security;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.service.MemberService;

@ApplicationScoped
public class CustomIdentityStore implements IdentityStore{

	@Inject
	private Pbkdf2PasswordHash encrypt;
	
	@Inject
	private MemberService service;
	
	@Override
	public CredentialValidationResult validate(Credential credential) {
		
		UsernamePasswordCredential userNameAndPasssword = (UsernamePasswordCredential) credential;
		
		Member member = service.findByEmail(userNameAndPasssword.getCaller());
		
		// check  is not deleted user
		if(null != member && !member.isDeleted()) {
			
			// check password
			if(encrypt.verify(userNameAndPasssword.getPasswordAsString().toCharArray(), member.getPassword())) {
				return new CredentialValidationResult(member.getEmail(), 
						Set.of(member.getRole().name()));
			}
		}

		return CredentialValidationResult.INVALID_RESULT;
	}
}
