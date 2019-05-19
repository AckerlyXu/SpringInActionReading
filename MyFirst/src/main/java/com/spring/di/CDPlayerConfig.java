package com.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.itcast.cn.Supplier1;
import com.spring.di.service.CompactDisc;
import com.spring.di.service.impl.CDPlayer;
import com.spring.di.service.impl.SgtPeppers;

@Configuration
@ComponentScan(basePackages="classpath:com.spring")
@PropertySource("classpath:/com/spring/di/config/app.properties")
public class CDPlayerConfig {
	@Autowired
	Environment env;
	@Bean(name="helloPeter")
	public CompactDisc sgtPeppers() {
		
		SgtPeppers pepper= new SgtPeppers();
	 pepper.setArtist(env.getProperty("article"));
	 pepper.setTitle(env.getProperty("title"));
	
	 return pepper;
	}
	           
	private String name;
	@Bean(name="hello")
	public CDPlayer cdPlayer(CompactDisc sgtPeppers) {
	              CDPlayer cdPlayer = new CDPlayer();
	              cdPlayer.setCompactDisc(sgtPeppers);
	              return cdPlayer;

		
	}

}
