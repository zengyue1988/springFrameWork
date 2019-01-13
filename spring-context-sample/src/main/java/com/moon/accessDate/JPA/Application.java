package com.moon.accessDate.JPA;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.moon.accessDate.JPA.entity.Customer;
import com.moon.accessDate.JPA.entity.M_Customer;
import com.moon.accessDate.JPA.entity.M_Order;
import com.moon.accessDate.JPA.entity.M_Product;
import com.moon.accessDate.JPA.repository.CustomerRepository;
import com.moon.accessDate.JPA.repository.OrderRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository, OrderRepository orderRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			/*
			repository.findById(1L)
			.ifPresent(customer -> {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
				log.info("");
			});
			*/
			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
			// fetch customers by last name and first name
			log.info("--------------------------------------------");
			repository.findByLastNameAndFirstName("Bauer", "Kim").forEach(customer -> {System.out.println(customer);});
			System.out.println("--------------------------------------------");
			M_Order order = orderRepository.findOne(1);
			System.out.println(JSONObject.toJSON(order).toString());
		};
	}


}
