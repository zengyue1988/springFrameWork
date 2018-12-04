package com.moon.springAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.moon.springAnnotation.service.HelloService;

@ComponentScan(value="com.moon.springAnnotation")
public class Application {

	/**
	 * <context:component-scan base-package="cn.outofmemory.spring" use-default-filters="false">
	 * 	<context:include-filter type="regex" expression="cn\.outofmemory\.spring\.[^.]+(Dao|Service)"/>
	 * </context:component-scan>
	 */
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("/com/moon/springAnnotation/resources/*.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		HelloService helloService = context.getBean("helloService", HelloService.class);
		System.out.println("*****from host");
		System.out.println(helloService.sayHello());
	}

}
