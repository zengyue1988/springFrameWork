package com.moon.springSecurity.fast.repository;

import org.springframework.data.repository.CrudRepository;

import com.moon.springSecurity.fast.bean.M_User;

public interface UserRepository extends CrudRepository<M_User, Integer>{
	
	M_User findByUsername(String username);

}
