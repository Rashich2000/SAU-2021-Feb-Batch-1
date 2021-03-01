package com.au.rect;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
	    Rectangle rect = (Rectangle)factory.getBean(Rectangle.class);
	    rect.draw();
	    rect.printList();
	}
}
