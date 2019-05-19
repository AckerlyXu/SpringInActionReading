package com.spring.di.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.di.service.Dessert;
@Component
public class Child {
	@Autowired
	@Qualifier("cake")
    private Dessert dessert;
}
