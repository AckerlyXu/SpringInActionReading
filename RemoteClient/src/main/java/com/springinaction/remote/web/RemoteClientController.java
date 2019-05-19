package com.springinaction.remote.web;

import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.habuma.spittr.service.SpittleService;

@Controller
public class RemoteClientController {
@Autowired
@Qualifier("jaxWsPortProxyFactoryBean")
JaxWsPortProxyFactoryBean spittleService;
	@RequestMapping("/remote")
	@ResponseBody
	public String getRemote() {
  
 return "1";

		//return spittleService.get
	}
	
}
