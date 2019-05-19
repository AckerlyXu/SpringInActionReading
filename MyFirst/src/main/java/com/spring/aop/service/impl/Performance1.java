package com.spring.aop.service.impl;

import org.springframework.stereotype.Component;

import com.spring.aop.service.Performance;
@Component
public class Performance1 implements Performance {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
      System.out.println("我正在表演");
	}

}
