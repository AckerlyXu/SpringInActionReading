package com.spring.aop.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.aop.service.impl.EncoreableIntroducer;
import com.spring.aop.service.impl.TrackCounter;

import com.spring.di.service.impl.SgtPeppers;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopJavaConfig {
	@Bean
	public SgtPeppers setPeppers() {
		SgtPeppers peppers=new SgtPeppers();
	return peppers;
		
		
	}
	@Bean
	public Performance2 Performance() {
		return new Performance2();
		
	}
	@Bean
	public EncoreableIntroducer introduce() {
		
		return new EncoreableIntroducer();
	}
	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
		
	}

}
