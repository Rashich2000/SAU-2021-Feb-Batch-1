package com.au.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		
		//shapeService.getCircle().setName("New Circle Name");
		try {
			shapeService.getCircle().setName("Circle 1");
			shapeService.getCircle().getName();
			//shapeService.getCircle().setName(null);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());  
		}
		
		
	}

}
