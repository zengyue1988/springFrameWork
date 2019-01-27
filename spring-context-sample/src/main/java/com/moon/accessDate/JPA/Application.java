package com.moon.accessDate.JPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.moon.accessDate.JPA.repository.CouponRepository;
import com.moon.accessDate.JPA.repository.OrderRepository;

@EnableCaching
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(OrderRepository orderRepository, CouponRepository couponRepository) {
		return (args) -> {
//			M_Product product = new M_Product();
//			product.setProductName("Orange");
//			product.setProductType(2);
//			product.setProductPrice(new BigDecimal(5.6));
//			M_ProductDetails productDetials = new M_ProductDetails();
//			productDetials.setProductDescription("it's a fruit");
//			productDetials.setProduct(product);
//			productDetailsRepository.save(productDetials);
//			productDetailsRepository.delete(productDetials);
//			M_Product productF = productRepository.findOne(1);
//			productF.getProductDetails().setProduct(null);
			//productDetailsRepository.delete(1);
			
//			M_Order order = new M_Order();
//			order.setOrderNo("123456");
//			Set<M_Coupon> couponList = new HashSet<M_Coupon>();
//			M_Coupon coupon = null;
//			for(int i=0; i<3; i++) {
//				coupon = new M_Coupon();
//				coupon.setCouponType(i);
//				couponList.add(coupon);
//			}
//			order.setCouponList(couponList);
//			orderRepository.save(order);
//			
//			M_Order order1 = orderRepository.findOne(9);
//			System.out.println(JSONObject.toJSON(order1));
			
		};
		
	}


}
