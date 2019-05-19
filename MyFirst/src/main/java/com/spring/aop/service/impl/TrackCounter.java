package com.spring.aop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class TrackCounter {
	private Map<Integer, Integer>trackCounts=
			new HashMap<>();
//	@Pointcut(
//   "execution(* com.spring.di.service.CompactDisc.playTrack(int))"+
//	"&& args(trackNumber)" +" )"
//			)
	public void trackPlayed(int trackNumber) {}
	
	//@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber) {
		System.out.println("Í¨ÖªÆôÓÃ");
	trackCounts.put(trackNumber, 	getPlayCount(trackNumber)+1);
	}
	public int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber)?
				trackCounts.get(trackNumber):0;
	}
	

}
