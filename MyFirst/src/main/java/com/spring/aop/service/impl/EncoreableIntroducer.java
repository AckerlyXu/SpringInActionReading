package com.spring.aop.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import com.spring.aop.service.Encoreable;

@Aspect
public class EncoreableIntroducer {
	
	@DeclareParents(value="com.spring.aop.service.Performance+"
			,defaultImpl=DefaultEncoreable.class)
	
	public static Encoreable encoreable;

}
