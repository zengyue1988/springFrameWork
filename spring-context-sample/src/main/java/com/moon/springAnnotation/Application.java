package com.moon.springAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.moon.springAnnotation.service.HelloService;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/moon/springAnnotation/resources/*.xml");
		HelloService helloService = context.getBean("helloService", HelloService.class);
		System.out.println("*****");
		System.out.println("**123**");
		System.out.println("!!!!!");
		System.out.println(helloService.sayHello());
	}

}
