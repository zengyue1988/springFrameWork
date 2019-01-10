package com.moon.springBoot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moon.accessDate.JPA.entity.Customer;
import com.moon.springBoot.bean.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String template2 = "Hello, %s %s! %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
	@RequestMapping("/customer/new/{customerNo}")
	public @ResponseBody Greeting createCustomer(
			@PathVariable("customerNo") Integer customerNo,
			@RequestParam("firstName") String firstName,
			@RequestParam(value="lastName",required=false,defaultValue="Moon") String lastName
			) {
		return new Greeting(counter.incrementAndGet(),
                String.format(template2, firstName, lastName, customerNo));
	}

}