package com.spring.di.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.spring.di.CDPlayerConfig;

@Configuration
@Import({Config1.class,Config2.class})
//@ImportResource("classpath:combinedConfig.xml")
public class SoundsSystemConfig {

}
