package com.habuma.spittr.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;







@Configuration

@ImportResource({"classpath:jms.xml","classpath:amqp.xml"})
@ComponentScan(
		basePackages= {"com.habuma.spittr.alerts"},
		excludeFilters= {
				@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
				
		}
		)
@PropertySource(value="classpath:mailProp.properties")

public class RootConfig {
	@Value("${mailserver.username}")
	private String username;
	
	private String passowrd;
	@Value("${mailserver.host}")
	private String host;

	@Bean
	public JavaMailSender mailSender (Environment env) {
		 JavaMailSenderImpl impl=new JavaMailSenderImpl();
		 String hoString=env.getProperty("mailserver.host");
		 impl.setHost(hoString);
		 String username1=env.getProperty("mailserver.username");
		 username1=username;
		 impl.setDefaultEncoding("UTF-8");
	
		String password=env.getProperty("mailserver.password");
		 impl.setUsername(username1);
		 impl.setPassword(password);
		 return impl;
	}
	@Bean

	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer placeholderConfigurer=new PropertySourcesPlaceholderConfigurer();
		placeholderConfigurer.setFileEncoding("UTF-8");
		Resource resource=new ClassPathResource("mailProp.properties");
		placeholderConfigurer.setLocations(resource);
		return placeholderConfigurer;
	}
/*	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer placeholderConfigurer=new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setFileEncoding("UTF-8");
		Resource resource=new ClassPathResource("mailProp.properties");
		placeholderConfigurer.setLocations(resource);
		placeholderConfigurer.setLocalOverride(true);
		return placeholderConfigurer;
	}*/
	/*@Bean
	public static ReloadableResourceBundleMessageSource  messageSource() {
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
		Resource resource=new ClassPathResource("mailProp.properties");

		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}*/
	
	
	

}
