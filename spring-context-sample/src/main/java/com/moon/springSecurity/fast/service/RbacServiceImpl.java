package com.moon.springSecurity.fast.service;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import com.moon.springSecurity.fast.bean.M_Permission;
import com.moon.springSecurity.fast.bean.M_Role;
import com.moon.springSecurity.fast.bean.M_User;
import com.moon.springSecurity.fast.repository.UserRepository;

@Service(value="rbacService")
public class RbacServiceImpl implements RbacService {
	
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		Object principal = authentication.getPrincipal();
		boolean hasPermission = false;
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			M_User user = userRepository.findByUsername(username);
			Set<String> urls = new HashSet<String>();
			for (M_Role role : user.getRoleList()) {
				for (M_Permission permission : role.getPermissionList()) {
					urls.add(permission.getPermissionUrl());
				}
			}
			for (String url : urls) {
				if (antPathMatcher.match(url, request.getRequestURI())) {
					hasPermission = true;
					break;
				}
			}
		}
		return hasPermission;
	}

}
