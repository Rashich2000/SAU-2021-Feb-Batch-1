package com.au.aop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		
			if (name==null){
				throw new Exception("Null Name");
			}
			else this.name=name;
		
		
	}
}
