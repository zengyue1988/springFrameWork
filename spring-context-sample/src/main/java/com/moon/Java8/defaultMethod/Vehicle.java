package com.moon.Java8.defaultMethod;

public interface Vehicle {
	
	default void print(){
		System.out.println("我是一辆车!");
    }
	static void blowHorn(){
		System.out.println("按喇叭!!!");
	}

}
