package com.spring.di.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.di.service.CompactDisc;
import com.spring.di.service.MediaPlayer;


@Component("cdPlayer")
public class CDPlayer implements MediaPlayer {
 
	private CompactDisc compactDisc;
	
	public CompactDisc getCompactDisc() {
		return compactDisc;
	}
                            @Autowired
	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	@Override
	public void play() {
		this.compactDisc.play();

	}

}
