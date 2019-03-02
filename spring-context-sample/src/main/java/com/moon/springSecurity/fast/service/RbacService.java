package com.moon.springSecurity.fast.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

public interface RbacService {
	
	public boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
