package com.moon.accessDate.JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.accessDate.JPA.entity.Customer;
import com.moon.accessDate.JPA.repository.CustomerRepository;

@Service
@Transactional(readOnly=true)
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	// order 3
	public List<Customer> orderCustomers(Customer customer) {
		Sort sort = new Sort(Direction.DESC, "firstName");
		return customerRepository.findAll(sort);
	}
	
}
