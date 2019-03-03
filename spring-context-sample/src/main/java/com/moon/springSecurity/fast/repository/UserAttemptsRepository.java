package com.moon.springSecurity.fast.repository;

import org.springframework.data.repository.CrudRepository;

import com.moon.springSecurity.fast.bean.M_UserAttempts;

public interface UserAttemptsRepository extends CrudRepository<M_UserAttempts, Integer>{
	
	M_UserAttempts findByUsername(String username);

}
