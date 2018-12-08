package com.moon.Java8.funcationalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class HelloFunctionalInterface {
	
	/**
	 * 
	 * 
	 * JDK 1.8 之前已有的函数式接口:
	 *
	 * java.lang.Runnable
	 * java.util.concurrent.Callable
	 * java.security.PrivilegedAction
	 * java.util.Comparator
	 * java.io.FileFilter
	 * java.nio.file.PathMatcher
	 * java.lang.reflect.InvocationHandler
	 * java.beans.PropertyChangeListener
	 * java.awt.event.ActionListener
	 * javax.swing.event.ChangeListener
	 * 
	 * JDK 1.8 新增加的函数接口：
	 *
	 * java.util.function
	 * 
	 */
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 9);
		System.out.println("输出所有 数");
		eval(list, n-> true);
		System.out.println("输出所有偶数");
		eval(list, n -> n%2 == 0);
		System.out.println("输出所有大于 3的数");
		eval(list, n -> n > 3);
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		// normal 
		/*
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n);
			}
		}
		*/
		// lambda
		list.stream().filter(predicate).forEach(System.out::println);
	}

}
