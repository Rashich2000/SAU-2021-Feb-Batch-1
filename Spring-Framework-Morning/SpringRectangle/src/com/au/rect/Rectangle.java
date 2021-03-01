package com.au.rect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




@Component
public class Rectangle {
	 
	  @Autowired
	  @Qualifier("PointA")
	  private Point pointA;
	  
	  @Autowired
	  @Qualifier("PointB")
	  private Point pointB;
	  
	  @Autowired
	  @Qualifier("PointC")
	  private Point pointC;
	  
	  @Autowired
	  @Qualifier("PointD")
	  private Point pointD;
	  
	  private Integer height;
	  private Integer width;
	  
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
	public Rectangle(Integer height,Integer width) {
		  this.height=height;
		  this.width=width;
	  }
	
	@Autowired
	@Qualifier("StrList")
	private List<String> strList;
	
	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public void draw() {
		  System.out.println("Rectangle drawn of height "+this.height+" and width "+this.width+"\n");
		  System.out.println("With points:\nPoint A: "+getPointA().getX()+" "+getPointA().getY()+"\nPoint B: "
				  + getPointB().getX()+" "+getPointB().getY()+"\nPoint C: "
						  + getPointC().getX()+" "+getPointC().getY()+"\nPoint D: "
								  + getPointD().getX()+" "+getPointD().getY());
		  }
	
	public void printList() {
		System.out.println("List is:\n");
		System.out.println(this.getStrList());
	}
	
	  
}
