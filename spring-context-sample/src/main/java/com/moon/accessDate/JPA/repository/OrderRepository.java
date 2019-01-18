package com.moon.accessDate.JPA.repository;

import org.springframework.data.repository.CrudRepository;

import com.moon.accessDate.JPA.entity.M_Customer;
import com.moon.accessDate.JPA.entity.M_Order;

public interface OrderRepository extends CrudRepository<M_Order, Integer>{
	
	Iterable<M_Order> findByOrderStatusAndCustomer(Integer orderStatus, M_Customer customer);
	
}
