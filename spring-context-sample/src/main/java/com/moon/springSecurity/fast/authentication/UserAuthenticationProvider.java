package com.moon.springSecurity.fast.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.moon.springSecurity.fast.bean.B_User;
import com.moon.springSecurity.fast.service.UserService;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// get username and password 
		String username = authentication.getName();                
		String password = (String) authentication.getCredentials();
		
		B_User user = (B_User) userService.loadUserByUsername(username);
		if (user !=null && user.getPassword().equals(password)) {
			return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		} else {
			throw new BadCredentialsException("bad credential");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
