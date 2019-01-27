package com.moon.accessDate.JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moon.accessDate.JPA.entity.M_ProductDetails;
import com.moon.accessDate.JPA.repository.ProductDetailsRepository;

@Service
@Transactional(readOnly=true)
public class ProductDetailsService {

	@Autowired
	private ProductDetailsRepository productDetialsRepository;
	@Autowired
	private ProductDetailsSubService productDetailsSubService;
	
	@Transactional
	public M_ProductDetails updateProduct(M_ProductDetails productDetails) {
		M_ProductDetails productDetailsLock = productDetialsRepository.queryProductDetailsByIdLocked(productDetails.getId());
		productDetailsLock.setProductDescription(productDetails.getProductDescription());
		return productDetialsRepository.save(productDetailsLock);
	}
	
	@Cacheable(value="Moon_cache", key="#id", condition="#id!=null")
	public M_ProductDetails findProductDetailsById(Integer id) {
		return productDetialsRepository.findById(id);
	}
	
	//@CacheEvict(value="Moon_cache", key="1001", beforeInvocation=true)
	@CachePut(value="Moon_cache", key="#productDetails.id")
	public M_ProductDetails updateProductDetails(M_ProductDetails productDetails) {
		return productDetialsRepository.save(productDetails);
	}
	
	/**
	 * propose roll back 8, 9, 10
	 * @param productDescription     aaa
	 * @param productDetailsList     8, 9, 10
	 * 
	 * Propagation.REQUIRED          if throw runtime exception, roll back all
	 */
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateProductDescriptionByIds1(String productDescription, List<Integer> productDetailsList) {
		M_ProductDetails productDetails = null;
		int i = 0;
		for (Integer productDetailId : productDetailsList) {
			if (i == productDetailsList.size() - 1)
				throw new RuntimeException("something running wrong");
			productDetails = new M_ProductDetails();
			productDetails.setId(productDetailId);
			productDetails.setProductDescription(productDescription);
			productDetialsRepository.save(productDetails);
			i++;
		}
	}
	/**
	 * propose roll back only 10, process with 8, 9
	 * @param productDescription     aaa
	 * @param productDetailsList     8, 9, 10
	 * 
	 * Propagation.NEW          create a new transaction to execute
	 */
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateProductDescriptionByIds2(String productDescription, List<Integer> productDetailsList) {
		int i = 0;
		for (Integer productDetailId : productDetailsList) {
			if (i == productDetailsList.size() - 1) {
				M_ProductDetails productDetails = new M_ProductDetails();
				productDetails.setId(productDetailId);
				productDetails.setProductDescription(productDescription);
				productDetialsRepository.save(productDetails);
				throw new RuntimeException("something running wrong");
			} else {
				productDetailsSubService.updateProductDescriptionById(productDescription, productDetailId);
			}
			i++;
		}
	}
	/**
	 * comment out @Transactional on class, propose throw an exception
	 * @param productDescription     aaa
	 * @param productDetailsList     8, 9, 10
	 * 
	 * Propagation.MANDATORY         must define transaction for a method
	 */
	public void updateProductDescriptionByIds3(String productDescription, List<Integer> productDetailsList) {
		M_ProductDetails productDetails = null;
		for (Integer productDetailId : productDetailsList) {
			productDetails = new M_ProductDetails();
			productDetails.setId(productDetailId);
			productDetails.setProductDescription(productDescription);
			productDetailsSubService.mustHaveTransaction();
		}
	}
	/**
	 * propose throw an exception
	 * @param productDescription     aaa
	 * @param productDetailsList     8, 9, 10
	 * 
	 * Propagation.NEVER         must not define transaction
	 */
	public void updateProductDescriptionByIds4(String productDescription, List<Integer> productDetailsList) {
		M_ProductDetails productDetails = null;
		for (Integer productDetailId : productDetailsList) {
			productDetails = new M_ProductDetails();
			productDetails.setId(productDetailId);
			productDetails.setProductDescription(productDescription);
			productDetailsSubService.mustNotHaveTransaction();
		}
	}
	/**
	 * propose success for 8, 9, 10
	 * @param productDescription     aaa
	 * @param productDetailsList     8, 9, 10
	 * 
	 * Propagation.SUPPORTS         if current exists transaction then support transaction, else not support transaction
	 */
	public void updateProductDescriptionByIds5(String productDescription, List<Integer> productDetailsList) {
		int i = 0;
		for (Integer productDetailId : productDetailsList) {
			if (i == productDetailsList.size() - 1) {
				M_ProductDetails productDetails = new M_ProductDetails();
				productDetails.setId(productDetailId);
				productDetails.setProductDescription(productDescription);
				productDetialsRepository.save(productDetails);
			} else {
				productDetailsSubService.updateProductDescriptionById(productDescription, productDetailId);
			}
			i++;
		}
	}
}
