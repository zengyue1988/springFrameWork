package com.moon.springXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moon.springXML.service.HelloService;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/moon/springXML/resources/services.xml", "/com/moon/springXML/resources/daos.xml");
		
		HelloService helloService = context.getBean("helloService", HelloService.class);
		System.out.println(helloService.sayHello());
	}

}
