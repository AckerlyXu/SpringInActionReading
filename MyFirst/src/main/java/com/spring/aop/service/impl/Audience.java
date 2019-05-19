package com.spring.aop.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.orm.jpa.aspectj.JpaExceptionTranslatorAspect;

import com.spring.aop.service.Performance;

//@Aspect
public class Audience {
//	@Pointcut("execution(** com.spring.aop.service.Performance.perform(..))")
//	public void performance() {};
	//@Before("performance()")
	public void slienceCllPhones() {
		
		System.out.println("Silencing cell phones");
	}
	//@Before("performance()")
	public void takeSeats() {
		System.out.println("taking seats");
	}
	//@AfterReturning("performance()")
	public void applause() {
		System.out.println("clap clap clap !!!");
	}
	
	//@AfterThrowing("performance()")
	public void demandRefud() {
		System.out.println("Demanding a refund");
	}
//     @Around("performance()")
     public void watchPerformance(ProceedingJoinPoint joinPoint) {
    	 
    	 try {
			System.out.println("Silencing the phone ...");
			System.out.println("Taking seats");
			joinPoint.proceed();
			System.out.println("Clap Clap Clap !!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refune");
		}
    	 
     }
}
