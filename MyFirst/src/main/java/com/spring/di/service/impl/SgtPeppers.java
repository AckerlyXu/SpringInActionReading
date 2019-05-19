package com.spring.di.service.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.spring.di.service.CompactDisc;

//@Component("hello")
public class SgtPeppers implements CompactDisc {
private  String title="Sgt. Pepper's Lonely Hearing";
private  String artist="The Beatles";
 

private String[] tracks= {"a","b","c","d"};
	public String[] getTracks() {
	return tracks;
}

	public SgtPeppers(String title, String artist) {
	super();
	this.title = title;
	this.artist = artist;
	//this.tracks=tracks;
	
}

	public void playTrack(int trackNumber) {
		 System.out.println(tracks[trackNumber]);
	}
public String  getString() {
	return "method from bean";
}
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public SgtPeppers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void play() {
		// TODO Auto-generated method stub
		playTrack(1);
//            // tracks.forEach(System.out::println);
//   for (int i = 0; i < tracks.length; i++) {
//	playTrack(i);
//}
//     IntStream.rangeClosed(0, tracks.length-1).forEach(n->playTrack(n));
	}

}
