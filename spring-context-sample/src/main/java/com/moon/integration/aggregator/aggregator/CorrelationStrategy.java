package com.moon.integration.aggregator.aggregator;

public class CorrelationStrategy {
	
	public String check(String message) {
		System.out.println(message + " " + this.getClass());
		return String.valueOf(message.length());
	}

}
