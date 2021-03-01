package com.au.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	

	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}
	
	@After("allGetters()")
	public void AfterAdvice() {
		System.out.println("After all Get Methods");
		
	}
	  @AfterReturning("argsName(name)")
	  public void AfterReturningAdvice(String name)
	  { System.out.println("After Returning Advice "+name); }
	 
	
	  @AfterThrowing(pointcut="args(name)",throwing="ex") 
	  public void AfterThrowingAdvice(String name,Exception ex) {
	  System.out.println("After Throwing Exception "+name+" "+ex); }
	 
	
	  @Around("args(String)")
		public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
			Object o=null;
			try {
				System.out.println("Before Proceeding");
				o = proceedingJoinPoint.proceed();
				System.out.println("After returning");
			} catch (Throwable e) {
				System.out.println("After throwing");
			}
			System.out.println("After finally");
			return o;
		}
	
	 @Pointcut("args(name)") 
	 public void argsName(String name) {
	 
		 
	 }
	 
	 @Pointcut("within(com.au.aop.model.Circle)")
	 public void Circles() {
	 }
	 
	 
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
	}
	
	
	
}
