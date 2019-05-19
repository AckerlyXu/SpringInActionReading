package com.habuma.spittr.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.habuma.spittr.model.Spittle;
import com.habuma.spittr.service.SpittleService;
@WebService(serviceName="jaxSpittleService")
@Component
public class SpitterServiceEndpoint extends SpringBeanAutowiringSupport {
   @Autowired
   SpittleService spittleService;
   @WebMethod
   public Spittle getSpittle() {
	   return spittleService.getSpittle(10l);
   }
}
