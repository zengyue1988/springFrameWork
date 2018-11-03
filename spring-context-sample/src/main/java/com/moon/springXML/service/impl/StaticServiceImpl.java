package com.moon.springXML.service.impl;

public class StaticServiceImpl{
	
	private static StaticServiceImpl staticService = new StaticServiceImpl();;
	
	public static StaticServiceImpl createInstance(){
		return staticService;
	}

}
