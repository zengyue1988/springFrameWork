package com.moon.integration.router.consumer;

import com.moon.integration.helloworld.service.HelloService;

public class MyHelloServiceTwo implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + " this is MyHelloServiceTwo");
	}

}
