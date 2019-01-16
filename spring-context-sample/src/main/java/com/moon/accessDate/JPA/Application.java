package com.moon.accessDate.JPA;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.moon.accessDate.JPA.entity.M_Product;
import com.moon.accessDate.JPA.entity.M_ProductDetails;
import com.moon.accessDate.JPA.repository.ProductDetailsRepository;
import com.moon.accessDate.JPA.repository.ProductRepository;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ProductDetailsRepository productDetailsRepository) {
		return (args) -> {
			M_Product product = new M_Product();
			product.setProductName("Orange");
			product.setProductType(2);
			product.setProductPrice(new BigDecimal(5.6));
			M_ProductDetails productDetials = new M_ProductDetails();
			productDetials.setProductDescription("it's a fruit");
			productDetials.setProduct(product);
			productDetailsRepository.save(productDetials);
			productDetailsRepository.delete(productDetials);
			// find entity  (one to one two way)  set null for inverse object
			M_Product productF = productRepository.findOne(1);
			productF.getProductDetails().setProduct(null);
		};
		
	}


}
