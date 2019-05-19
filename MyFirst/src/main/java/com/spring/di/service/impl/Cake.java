package com.spring.di.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.di.service.Dessert;
@Component
//@Primary  设置为首选bean
@Qualifier("deliciousCake") //自定义限定符名称
public class Cake implements Dessert {

}
