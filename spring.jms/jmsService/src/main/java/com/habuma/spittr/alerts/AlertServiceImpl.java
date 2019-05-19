package com.habuma.spittr.alerts;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.habuma.spittr.model.Spittle;

@Service
public class AlertServiceImpl implements AlertService{
	
    private JmsOperations jmsOperations;
    @Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		super();
		this.jmsOperations = jmsOperations;
	}

	@Override
	public void sendSpittleAlert(Spittle spittle) {
//		jmsOperations.send(//"spittle.alert.queue",
//				new MessageCreator() {
//					
//					@Override
//					public Message createMessage(Session session) throws JMSException {
//						// TODO Auto-generated method stub
//						return session.createObjectMessage(spittle);
//					}
//				}
//				
//				);
		/*jmsOperations.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("hello");
			}
		});*/

		jmsOperations.convertAndSend(spittle);
		
	}

	@Override
	public Spittle getSpittle() {
		// TODO Auto-generated method stub
		return  new Spittle();
	}

}
