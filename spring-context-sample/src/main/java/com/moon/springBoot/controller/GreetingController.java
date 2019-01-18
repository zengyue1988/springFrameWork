package com.moon.springBoot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moon.springBoot.bean.Greeting;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
	schemes = {SwaggerDefinition.Scheme.HTTPS}
)
@Api(
		value = "API information",
		consumes = "application/json",
		produces = "application/json"
)
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

    @ApiOperation(value = "create a customer")
    @ApiResponses(value= {
    		@ApiResponse(code=400, message="Invalid request"),
    		@ApiResponse(code=404, message="api not found"),
    		@ApiResponse(code=500, message="Server error"),
    })
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