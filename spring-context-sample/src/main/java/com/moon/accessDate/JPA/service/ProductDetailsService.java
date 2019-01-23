package com.moon.accessDate.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.accessDate.JPA.entity.M_ProductDetails;
import com.moon.accessDate.JPA.repository.ProductDetailsRepository;

@Service
public class ProductDetailsService {

	@Autowired
	private ProductDetailsRepository productDetialsRepository;
	
	public M_ProductDetails updateProductDetails(M_ProductDetails productDetails) {
		M_ProductDetails productDetailsLock = productDetialsRepository.queryProductDetailsByIdLocked(productDetails.getId());
		productDetailsLock.setProductDescription(productDetails.getProductDescription());
		return productDetialsRepository.save(productDetailsLock);
	}
	
}
