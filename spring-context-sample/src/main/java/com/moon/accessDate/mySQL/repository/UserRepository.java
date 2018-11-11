package com.moon.accessDate.mySQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.moon.accessDate.mySQL.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
