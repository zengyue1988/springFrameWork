package com.moon.Java8.methodReference;

import java.util.Arrays;
import java.util.List;

public class HelloMethodReference {

	public static void main(String[] args) {
		// constructor reference
		final Car car = Car.create(Car::new);
		final List< Car > cars = Arrays.asList( car );
		// static method reference
		cars.forEach(Car::collide);
		// special method reference
		cars.forEach(Car::repair);
		// special object method reference
		cars.forEach(car::follow);
	}

}
