package com.moon.springAnnotation.service.impl;

import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value="resourceService")
@Scope("prototype")
@Description("Provides resource service")
public class ResourceServiceImpl {
	
	public String getResource(){
		return "resource";
	}

}
