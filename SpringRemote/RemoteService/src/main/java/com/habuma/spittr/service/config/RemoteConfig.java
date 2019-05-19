package com.habuma.spittr.service.config;

import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.habuma.spittr.model.Spittle;
import com.habuma.spittr.service.SpittleService;
import com.habuma.spittr.service.impl.SpittleServiceImpl;

@Configuration
@ComponentScan(basePackages="com.habuma.spittr.service")
public class RemoteConfig {

	/*@Bean
	public RmiServiceExporter rmiServiceExporter(SpittleService service) {
		RmiServiceExporter rmiServiceExporter=new RmiServiceExporter();
		rmiServiceExporter.setService(service);
		rmiServiceExporter.setServiceName("spittleService");
		

		rmiServiceExporter.setServiceInterface(SpittleService.class);
	
		rmiServiceExporter.setServicePort(8084);;
		rmiServiceExporter.setRegistryPort(8090);
		return rmiServiceExporter;
	}*/
	@Bean
	public HessianServiceExporter hessianServiceExporter(SpittleService service) {

		HessianServiceExporter exporter=new HessianServiceExporter();
		exporter.setService(service);
		exporter.setServiceInterface(SpittleService.class);
		return exporter;
	}
	@Bean(name="spittleServiceImpl")
	public SpittleService spittleServiceImpl() {
		return new SpittleServiceImpl();
	}
	@Bean
	public HandlerMapping hessianMapping() {
		SimpleUrlHandlerMapping mapping=new SimpleUrlHandlerMapping();
		Properties properties=new Properties();
		//hessianExportSpitterService是HessionServiceExporter类型的bean的id
		properties.setProperty("/spittle.service","hessianServiceExporter");
		properties.setProperty("/burlapSpittle.service", "burlapServiceExporter");
	          properties.setProperty("/invokerSpittle.service", "httpInvokerServiceExporter");
		mapping.setMappings(properties);
		return mapping;
	}
	
	@Bean
	public BurlapServiceExporter burlapServiceExporter(SpittleService spittleService) {
		BurlapServiceExporter exporter=new BurlapServiceExporter();
		exporter.setService(spittleService);
		exporter.setServiceInterface(SpittleService.class);;
		return exporter;
	}
	@Bean
	public HttpInvokerServiceExporter httpInvokerServiceExporter(SpittleService service) {
		HttpInvokerServiceExporter exporter=new HttpInvokerServiceExporter();
		exporter.setService(service);
		exporter.setServiceInterface(SpittleService.class);
		return exporter;
	}
	@Bean
	public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		//注意这里的端口号要与应用本身的端口号不同
		exporter.setBaseAddress("http://localhost:8085/");
		return exporter;
	}
}
