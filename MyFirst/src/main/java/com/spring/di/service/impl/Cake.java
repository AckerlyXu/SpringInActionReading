package com.spring.di.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.di.service.Dessert;
@Component
//@Primary  ����Ϊ��ѡbean
@Qualifier("deliciousCake") //�Զ����޶�������
public class Cake implements Dessert {

}
