package com.habuma.spittr.web;


import java.time.LocalDate;

import org.springframework.amqp.rabbit.support.PublisherCallbackChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habuma.spittr.model.Spittle;

@RestController
public class MailController {
@Autowired
JavaMailSender mailSender;
	@RequestMapping("/sendMail")
	public String sendMail() {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		 Spittle spittle=new Spittle();
			spittle.setMessage("from server");
			spittle.setLongitude(123.1);
			spittle.setLatitude(12.5);
			spittle.setTime( LocalDate.of(1994, 9, 13));
			spittle.setId(101l);
		mailMessage.setFrom("1290272597@qq.com");
		mailMessage.setTo("1290272597@qq.com");
		mailMessage.setSubject("test");
		mailMessage.setText("hello world");
		mailSender.send(mailMessage);
		return "sendSuccessfully";
	}
}
