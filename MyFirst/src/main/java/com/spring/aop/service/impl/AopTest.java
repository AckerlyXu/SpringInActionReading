package com.spring.aop.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.aop.service.AopJavaConfig;
import com.spring.aop.service.Performance;
import com.spring.di.service.impl.SgtPeppers;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopJavaConfig.class)
public class AopTest {

	@Autowired
	private SgtPeppers sgtPeppers;
	@Autowired
	private TrackCounter counter;
	@Autowired
	private Performance performance;
	@Test
	public void test() {
		//cd.playTrack(0);
//		cd.playTrack(1);
//		cd.playTrack(0);
//		cd.playTrack(3);
//		cd.playTrack(2);
//		cd.playTrack(2);
//		cd.playTrack(2);
//		cd.play();
		//sgtPeppers.play();
		
		System.out.println(counter.getPlayCount(0));
		assertEquals(3,counter.getPlayCount(0) );
		
		//assertEquals(1, counter.countTrack(1)); 
	}

}
