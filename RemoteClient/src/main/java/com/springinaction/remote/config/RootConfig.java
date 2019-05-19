package com.springinaction.remote.config;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.habuma.spittr.service.SpittleService;



@Configuration


@ComponentScan(
		basePackages= {"com.springinaction.remote.config"},
		excludeFilters= {
				@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
				
		}
		)
public class RootConfig {
	
	/*@Bean
	public RmiProxyFactoryBean spittleService() {
		RmiProxyFactoryBean rmiProxyFactoryBean=new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://192.168.25.1:8090/spittleService");
		rmiProxyFactoryBean.setServiceInterface(SpittleService.class);
		return rmiProxyFactoryBean;
	}*/
	/*@Bean
	public HessianProxyFactoryBean spitterService() {
		HessianProxyFactoryBean proxy=new HessianProxyFactoryBean();
		proxy.setServiceUrl("http://localhost:8084/spittle.service");
		proxy.setServiceInterface(SpittleService.class);
		return proxy;
		
		
	}
	@Bean
	public BurlapProxyFactoryBean burlapProxyFactoryBean() {
		BurlapProxyFactoryBean proxyFactoryBean=new BurlapProxyFactoryBean();
		proxyFactoryBean.setServiceUrl("http://localhost:8084/burlapSpittle.service");
		proxyFactoryBean.setServiceInterface(SpittleService.class);
		return proxyFactoryBean;
	}*/
	@Bean
	public HttpInvokerProxyFactoryBean invokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean proxyFactoryBean=new HttpInvokerProxyFactoryBean();
		proxyFactoryBean.setServiceUrl("http://localhost:8084/invokerSpittle.service");
		proxyFactoryBean.setServiceInterface(SpittleService.class);
		return proxyFactoryBean;
	}
	@Bean
	public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean() throws MalformedURLException {
		JaxWsPortProxyFactoryBean proxyFactoryBean=new JaxWsPortProxyFactoryBean();
		proxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:8085/jaxSpittleService?wsdl"));
		proxyFactoryBean.setServiceName("jaxSpittleService");
		proxyFactoryBean.setPortName("SpitterServiceEndpointPort");
		proxyFactoryBean.setServiceInterface(SpittleService.class);
		proxyFactoryBean.setNamespaceUri("http://impl.service.spittr.habuma.com/");
		return proxyFactoryBean;
	}
}
