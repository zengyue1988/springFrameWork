package com.moon.integration.channelAdapter.input;

public class MyHelloService implements HelloService {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

}
