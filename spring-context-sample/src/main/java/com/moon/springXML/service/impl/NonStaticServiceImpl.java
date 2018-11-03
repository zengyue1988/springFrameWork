package com.moon.springXML.service.impl;

public class NonStaticServiceImpl{
	
	private static NonStaticServiceImpl nonStaticService = new NonStaticServiceImpl();;
	
	public NonStaticServiceImpl createInstance(){
		return nonStaticService;
	}

}
