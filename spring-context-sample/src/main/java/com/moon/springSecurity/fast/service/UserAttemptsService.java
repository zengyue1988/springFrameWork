package com.moon.springSecurity.fast.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.springSecurity.fast.bean.M_User;
import com.moon.springSecurity.fast.bean.M_UserAttempts;
import com.moon.springSecurity.fast.repository.UserAttemptsRepository;
import com.moon.springSecurity.fast.repository.UserRepository;

@Service
public class UserAttemptsService {
	
	@Autowired
	private UserAttemptsRepository userAttemptsRepository;
	@Autowired
	private UserRepository userRepository;
	
	private static final int MAX_ATTEMPTS = 3;
	
	public void resetUserAttempts(String username) {
		M_UserAttempts userAttempts = userAttemptsRepository.findByUsername(username);
		if (userAttempts != null) {
			userAttempts.setAttempts(0);
			userAttempts.setLastModified(null);
			userAttemptsRepository.save(userAttempts);
		}
	}
	
	public void updateFailureAttempts(String username) {
		M_UserAttempts userAttempts = userAttemptsRepository.findByUsername(username);
		if (userAttempts != null) {
			userAttempts.setAttempts(userAttempts.getAttempts()+1);
			userAttempts.setLastModified(new Date());
			userAttempts = userAttemptsRepository.save(userAttempts);
			
			if (userAttempts.getAttempts() >= MAX_ATTEMPTS) {
				// lock user
				M_User user = userRepository.findByUsername(username);
				user.setAccountNonLocked(1);
				userRepository.save(user);
			}
		} else {
			if (userRepository.findByUsername(username) != null) {
				userAttempts = new M_UserAttempts();
				userAttempts.setAttempts(1);
				userAttempts.setUsername(username);
				userAttempts.setLastModified(new Date());
				userAttempts = userAttemptsRepository.save(userAttempts);
			}
		}
	}
}
