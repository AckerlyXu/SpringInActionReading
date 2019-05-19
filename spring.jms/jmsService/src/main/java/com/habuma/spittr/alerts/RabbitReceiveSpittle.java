package com.habuma.spittr.alerts;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habuma.spittr.model.Spittle;
@Service
public class RabbitReceiveSpittle implements ReveiveSpittleMessage {
/*@Autowired*/
RabbitTemplate rabbitTemplate;
	@Override
	public Object retrieveSpittleAlert() {
		// TODO Auto-generated method stub
	return 	rabbitTemplate.receiveAndConvert("spittle.alerts");
	
	}

	@Override
	public void handlerSpittleAlert(Spittle spittle) {
		// TODO Auto-generated method stub

	}

}
