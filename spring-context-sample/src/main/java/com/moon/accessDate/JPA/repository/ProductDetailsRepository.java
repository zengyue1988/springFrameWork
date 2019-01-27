package com.moon.accessDate.JPA.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moon.accessDate.JPA.entity.M_ProductDetails;

public interface ProductDetailsRepository extends CrudRepository<M_ProductDetails, Integer>{
	
	/**
	 * LockModeType JPA 2.0
	 * 
	 * OPTIMISTIC                    optimistic lock, synonymous with READ
	 * OPTIMISTIC_FORCE_INCREMENT    optimistic lock, with version update
	 * PESSIMITIC_READ               pessimistic read lock
	 * PESSIMITIC_WRITE              pessimistic write lock
	 * PESSIMITIC_FORCE_INCREMENT    pessimistic write lock, with version update
	 * NONE
	 * 
	 */
	@Lock(value = LockModeType.PESSIMISTIC_WRITE)
	@Query("select pd from M_ProductDetails pd where pd.id = :productDetailsId")
	M_ProductDetails queryProductDetailsByIdLocked(@Param("productDetailsId") Integer productDetailsId);
	
	M_ProductDetails findById(Integer id);

}
