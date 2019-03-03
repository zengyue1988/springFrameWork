package com.moon.springSecurity.fast.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.moon.springSecurity.fast.service.UserAttemptsService;

@Component
public class UserAuthenticationProvider extends DaoAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserAttemptsService userAttemptsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// get username and password 
		String username = authentication.getName();                
		String password = (String) authentication.getCredentials();
		
		try {
			Authentication auth = super.authenticate(authentication);
			// reset user attempts
			userAttemptsService.resetUserAttempts(username);
			return auth;
		} catch (BadCredentialsException bce) {
			userAttemptsService.updateFailureAttempts(username);
			throw bce;
	    } catch (LockedException le) {
	    	throw le;
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	@Override
	@Autowired
	@Qualifier("userService")
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}

}
