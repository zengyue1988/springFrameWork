package com.moon.springSecurity.fast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moon.springSecurity.fast.bean.M_Permission;
import com.moon.springSecurity.fast.bean.M_Role;
import com.moon.springSecurity.fast.bean.M_User;
import com.moon.springSecurity.fast.repository.UserRepository;

@Service(value = "userService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		M_User user = userRepository.findByUsername(username);
		
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
//			user.setPassword(encodedPassword);
//			userRepository.save(user);
		
		List<SimpleGrantedAuthority> authrities = new ArrayList<SimpleGrantedAuthority>();
		for (M_Role role : user.getRoleList()) {
			for (M_Permission permission : role.getPermissionList()) {
				authrities.add(new SimpleGrantedAuthority(permission.getPermissionCode()));
			}
		}
		return new User(username, user.getPassword(), authrities);

	}

}
