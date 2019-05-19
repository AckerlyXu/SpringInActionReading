package com.spring.aop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.aop.service.Performance;
@Component
@Primary
public class Performances implements Performance {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
System.out.println("Performances");
	}

}
