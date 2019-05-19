package com.habuma.spittr.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habuma.spittr.alerts.AlertService;
import com.habuma.spittr.alerts.ReceiveSpittle;
import com.habuma.spittr.alerts.ReveiveSpittleMessage;
import com.habuma.spittr.model.Spittle;

@RestController
public class MessageController {
	@Autowired
	@Qualifier("alertServiceImpl")
	AlertService alertService;
	
	/*@Autowired
	@Qualifier("receiveSpittle")*/
	ReceiveSpittle receiveSpittle;
/*	@Autowired
	@Qualifier("rabbitReceiveSpittle")*/
	ReveiveSpittleMessage rabbitReceiver;
	
	
	/*@Autowired
	@Qualifier("alertService")*/
	AlertService alertService1;
	/*@Autowired
	@Qualifier("rabbitAlertServiceImpl")*/
	AlertService rabbitService;
@RequestMapping("/message/sendSpittle")
	public String sendMessage() {
	Spittle spittle=new Spittle();
	spittle.setMessage("from server");
	spittle.setLongitude(123.1);
	spittle.setLatitude(12.5);
	spittle.setTime( LocalDate.of(1994, 9, 13));
	spittle.setId(101l);
		alertService.sendSpittleAlert(spittle);
		return "sendSuccess";
	}
  @RequestMapping("/message/receiveSpittle")
  public String receiveMessage() {
	return  receiveSpittle.retrieveSpittleAlert().toString();
  }
  @RequestMapping("/remote")
  public  String remote() {
return	   alertService1.getSpittle().toString();

  }
  @RequestMapping("/rabbit/sendSpittle")
  public String sendRabbitMessage() {
	  Spittle spittle=new Spittle();
		spittle.setMessage("from server");
		spittle.setLongitude(123.1);
		spittle.setLatitude(12.5);
		spittle.setTime( LocalDate.of(1994, 9, 13));
		spittle.setId(101l);
			rabbitService.sendSpittleAlert(spittle);
			return "sendSuccess";
  }
  @RequestMapping("/message/rabbitReceiver")
  public Spittle rabbitReceiver() {
	Spittle spittle=  (Spittle)rabbitReceiver.retrieveSpittleAlert();
	return spittle;
  }
}
