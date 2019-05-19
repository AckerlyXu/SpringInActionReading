package com.spring.di.service.impl;

import java.util.List;

import com.spring.di.service.CompactDisc;

public class BlankDisc implements CompactDisc {
private String title;
private String artist;
private List<String> tracks;

	public void setTitle(String title) {
	this.title = title;
}

public void setArtist(String artist) {
	this.artist = artist;
}

public void setTracks(List<String> tracks) {
	this.tracks = tracks;
}

	@Override
	public void play() {
		// TODO Auto-generated method stub
      System.out.println("playing "+title+" by "+artist);;
      for (String string : tracks) {
		System.out.println("-Track :" + string);
	}
	}

	@Override
	public void playTrack(int trackNumber) {
		// TODO Auto-generated method stub
		
	}

}
