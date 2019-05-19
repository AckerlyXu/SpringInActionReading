package com.itcast.cn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.spring.condition.MagicCondition;

@Configuration
public class ConsumerConfig {
	
	@Bean
	@Conditional(MagicCondition.class)
	public ISupplier supplier() {
		
		return new Supplier2();
	}
//	@Bean(name="helloPeter")
//	public Cosumer consumer() {
//		
//		return new Cosumer(supplier());
//	}

}
