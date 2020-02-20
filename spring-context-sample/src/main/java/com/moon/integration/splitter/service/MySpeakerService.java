package com.moon.integration.splitter.service;

public class MySpeakerService implements SpeakerService {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

}
