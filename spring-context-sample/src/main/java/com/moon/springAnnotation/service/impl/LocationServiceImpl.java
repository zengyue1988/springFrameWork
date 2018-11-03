package com.moon.springAnnotation.service.impl;

import org.springframework.stereotype.Service;

@Service(value="newService")
public class LocationServiceImpl {
	
	public String getLocation(){
		return "China";
	}

}
