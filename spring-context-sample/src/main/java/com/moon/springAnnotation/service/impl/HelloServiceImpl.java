package com.moon.springAnnotation.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moon.springAnnotation.service.HelloService;

@Service(value="helloService")
public class HelloServiceImpl implements HelloService{
	
	@Autowired(required=true) 
	@Qualifier("newService")
	private LocationServiceImpl locationService;
	
	@Resource(name="resourceService")
	private ResourceServiceImpl newService;
	
	public String sayHello(){
		return "Hello " + locationService.getLocation() + " " + newService.getResource();
	}

	public LocationServiceImpl getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationServiceImpl locationService) {
		this.locationService = locationService;
	}

	public ResourceServiceImpl getNewService() {
		return newService;
	}

	public void setNewService(ResourceServiceImpl newService) {
		this.newService = newService;
	}

}
