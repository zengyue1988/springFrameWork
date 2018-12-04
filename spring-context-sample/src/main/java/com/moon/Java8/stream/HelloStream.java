package com.moon.Java8.stream;

import java.util.Arrays;
import java.util.List;

public class HelloStream {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, null, 3, 4, null, 6, 7, 8 ,9, 10, 10);
		nums.stream()
		.filter(n -> n !=null)
		.distinct()
		.mapToDouble(n -> n)
		.peek(System.out::println)
		.skip(2)
		.limit(4)
		.forEach(System.out::println);
	}

}
