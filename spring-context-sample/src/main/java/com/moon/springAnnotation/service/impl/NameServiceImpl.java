package com.moon.springAnnotation.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value="nameService")
@Scope("singleton")
public class NameServiceImpl {
	
	public String getName(){
		return "Moon";
	}

}
