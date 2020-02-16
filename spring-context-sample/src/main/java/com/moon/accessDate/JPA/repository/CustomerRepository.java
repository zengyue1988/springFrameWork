package com.moon.accessDate.JPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moon.accessDate.JPA.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);
	
	Iterable<Customer> findByLastNameAndFirstName(String lastName, String firstName);
	
	// order by 1
	Iterable<Customer> findAllByOrderByFirstNameDesc(String firstName);
	// order by 2
	@Query("select o from M_Order o ORDER BY o.orderDate DESC")
	Iterable<Customer> queryAllByOrderByOrderDateDesc();
	
}
