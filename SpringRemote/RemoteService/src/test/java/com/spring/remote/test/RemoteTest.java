package com.spring.remote.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.habuma.spittr.service.SpittleService;
import com.habuma.spittr.service.config.RemoteConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RemoteConfig.class)
class RemoteTest {
@Autowired
RmiServiceExporter rmiServiceExporter;
	@Test
	void test() {
		;
		//((SpittleService)rmiServiceExporter.getService()).getSpittle(11l)
	assertNotNull(rmiServiceExporter);
	}

}
