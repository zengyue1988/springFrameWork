package com.moon.integration.router.router;

public class MyRouterService implements RouterService {

	@Override
	public String sayWhat(String name) {
		System.out.println("sayWhat:" + name);
		return (name.equals("channel1")) ? "channelOne" : "channelTwo";
	}

}
