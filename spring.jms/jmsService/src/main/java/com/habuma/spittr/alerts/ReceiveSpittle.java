package com.habuma.spittr.alerts;



import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.management.j2ee.statistics.JMSProducerStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import com.habuma.spittr.model.Spittle;
@Service
public class ReceiveSpittle implements ReveiveSpittleMessage {
/*@Autowired*/
JmsOperations jmsOperations;
	@Override
	public Object retrieveSpittleAlert()  {
		// TODO Auto-generated method stub
 return	jmsOperations.receiveAndConvert();
	
	
	}
	@Override
	public void handlerSpittleAlert(Spittle spittle) {
		// TODO Auto-generated method stub
		System.out.println(spittle);
	}

}
