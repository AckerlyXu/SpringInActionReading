package com.spring.di.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.di.service.impl.CDPlayer;

@Configuration
@ComponentScan(basePackageClasses=CDPlayer.class)
public class Config2 {

}
