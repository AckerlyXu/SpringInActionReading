package com.habuma.spittr.alerts;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habuma.spittr.model.Spittle;
/*@Service*/
public class RabbitAlertServiceImpl implements AlertService {
@Autowired
private RabbitTemplate rabbit;
	@Override
	public void sendSpittleAlert(Spittle spittle) {
		// TODO Auto-generated method stub
       rabbit.convertAndSend( "spittle.alerts",spittle);
	}

	@Override
	public Spittle getSpittle() {
		// TODO Auto-generated method stub
		return null;
	}

}
