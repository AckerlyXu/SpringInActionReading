package com.spring.di;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itcast.cn.ISupplier;
import com.spring.di.service.CompactDisc;
import com.spring.di.service.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

	@Value("#{systemProperties['user.language']}")
	private String title;
	@Value("#{helloPeter.artist}")
	private String artist;
	@Value("#{helloPeter.getString().toUpperCase()}")
	private String name;
	@Value("#{T(Math).PI}")
	private String math;
	@Value("#{1==1}")
	private String flag;
	@Value("#{helloPeter.tracks[1]}")
	private String element;
	//@Value("#{helloPeter.tracks.?[ eq 'a']}")
	private String search;
	@Autowired
	private CompactDisc cd;
//	@Autowired
	private ISupplier supplier;
	
	@Autowired
	private MediaPlayer mediaPlayer;
	@Test
	public void test() {
//		assertNotNull(cd);
//		assertNotNull(supplier);
//		 mediaPlayer.play();

		System.out.println(artist);
		System.out.println(name);
		System.out.println(math);
		System.out.println(flag);
		System.out.println(element);
		System.out.println(search);
		 assertNotNull(title);
	}

}
