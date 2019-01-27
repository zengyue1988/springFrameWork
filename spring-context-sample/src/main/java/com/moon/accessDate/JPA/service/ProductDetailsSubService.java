package com.moon.accessDate.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moon.accessDate.JPA.entity.M_ProductDetails;
import com.moon.accessDate.JPA.repository.ProductDetailsRepository;

@Service
@Transactional(readOnly=true)
public class ProductDetailsSubService {

	@Autowired
	private ProductDetailsRepository productDetialsRepository;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateProductDescriptionById(String productDescription, Integer id) {
		M_ProductDetails productDetailsLock = new M_ProductDetails();
		productDetailsLock.setId(id);
		productDetailsLock.setProductDescription(productDescription);
		productDetialsRepository.save(productDetailsLock);
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public void mustHaveTransaction() {
		System.out.println("must have an active transaction");
	}
	
	@Transactional(propagation=Propagation.NEVER)
	public void mustNotHaveTransaction() {
		System.out.println("must not have an active transaction");
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void supportsTransaction(String productDescription, Integer id) {
		M_ProductDetails productDetailsLock = new M_ProductDetails();
		productDetailsLock.setId(id);
		productDetailsLock.setProductDescription(productDescription);
		productDetialsRepository.save(productDetailsLock);
	}
	
}
