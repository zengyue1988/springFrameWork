package com.moon.accessDate.JPA.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.moon.accessDate.JPA.entity.M_Product;
import com.moon.accessDate.JPA.entity.M_ProductDetails;

public interface ProductRepository extends CrudRepository<M_Product, Integer>{

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("update M_Product p set p.productName=:productName,p.productPrice=:productPrice,p.productType=:productType,p.productDetails=:productDetials,p.version=:version+1 where p.id=:productId and p.version=:version")
	int updateProductInfo(@Param("productName") String productName, @Param("productPrice") BigDecimal productPrice, @Param("productType") Integer productType, @Param("productDetials") M_ProductDetails productDetails, @Param("version") int version);
	
}
