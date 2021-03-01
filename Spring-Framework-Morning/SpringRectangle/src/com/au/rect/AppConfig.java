package com.au.rect;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean()
	public Rectangle getRectangle() {
		return new Rectangle(10,20);
	}
	
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(10,20);
	}
	
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(10,20);
	}
	
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(10,20);
	}
	
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(10,20);
	}
	
	@Bean(name="StrList")
    public List<String> strList(){
        return Arrays.asList("pink", "red", "yellow");
    }

}
