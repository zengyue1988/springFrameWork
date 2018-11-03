package com.moon.springXML.service.impl;

import com.moon.springXML.dao.HelloDao;
import com.moon.springXML.service.HelloService;

public class HelloServiceImpl implements HelloService{
	
	private HelloDao helloDao;
	
	private LocationServiceImpl newService;
	
	private StaticServiceImpl staticService;
	
	private NonStaticServiceImpl nonStaticService;
	
	public String sayHello(){
		System.out.println(staticService);
		System.out.println(nonStaticService);
		return "Hello " + helloDao.getName() + ", i am from " + newService.getLocation();
	}

	public HelloDao getHelloDao() {
		return helloDao;
	}

	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}

	public LocationServiceImpl getNewService() {
		return newService;
	}

	public void setNewService(LocationServiceImpl newService) {
		this.newService = newService;
	}

	public StaticServiceImpl getStaticService() {
		return staticService;
	}

	public void setStaticService(StaticServiceImpl staticService) {
		this.staticService = staticService;
	}

	public NonStaticServiceImpl getNonStaticService() {
		return nonStaticService;
	}

	public void setNonStaticService(NonStaticServiceImpl nonStaticService) {
		this.nonStaticService = nonStaticService;
	}

}
