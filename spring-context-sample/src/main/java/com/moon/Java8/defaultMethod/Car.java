package com.moon.Java8.defaultMethod;

public class Car implements FourWheeler, Vehicle {

	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
	    System.out.println("我是一辆汽车!");
	}

}
