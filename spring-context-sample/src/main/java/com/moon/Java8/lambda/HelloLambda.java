package com.moon.Java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelloLambda {

	public static void main(String[] args) {
		//// order list of String
		List<String> strList = Arrays.asList("a", "bcda", "dab", "cbc");
		// order by str unicode 
		Collections.sort(strList);
		System.out.println(strList);
		// order by str length
		// old way
		Collections.sort(strList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(strList);
		// new way
		Collections.sort(strList, (o1, o2) -> {
			return o1.length() - o2.length();
		});
		System.out.println(strList);
		
		//// order list of Object
		List<Item> itemList = Arrays.asList(new Item("Java", 12.2), new Item("Android", 13.2), new Item("JavaWeb", 11.2), new Item("Paython", 15.2));
		// order items by price
		Collections.sort(itemList, (o1, o2) -> {
			return (int) (o1.getPrice() - o2.getPrice());
		});
		itemList.forEach((i) -> System.out.println(i.getName()));
		
		//// runnable
		// create a new thread with old way
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("create a new thread in old way");
			}
		};
		r.run();
		// create a new thread with lambda
		Runnable r1 = () -> System.out.println("create a new thread with lambda");
		r1.run();
		
		//// Customize lambda
		MoonInterface moon = s -> {return s;};
		System.out.println(moon.moonSay("Hello"));
	}

}
