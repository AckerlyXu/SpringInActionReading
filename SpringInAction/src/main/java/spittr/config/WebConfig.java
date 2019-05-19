package spittr.config;


import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr")

public class WebConfig
extends WebMvcConfigurerAdapter
{
	
//	@Override
//	public Validator getValidator() {
//		// TODO Auto-generated method stub
//		
//
//		 ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
//		 
//		 source.setDefaultEncoding("UTF-8");
//		 source.setUseCodeAsDefaultMessage(true);
//		 source.setCacheSeconds(10);
//		 Properties properties=new Properties();
//		 properties.setProperty("classpath:messages", "UTF-8");
//		 source.setFileEncodings(properties);
//		 source.setBasenames("classpath:messages");
//		 LocalValidatorFactoryBean bean=new LocalValidatorFactoryBean();
//			bean.setProviderClass(HibernateValidator.class);
//			bean.setValidationMessageSource(source);
//
//		return bean;
//	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer=new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {
				
			"/WEB-INF/layout/tiles.xml"
		});
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
	
@Bean
 public MessageSource messageSource() {
	 ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
	 source.setDefaultEncoding("UTF-8");
	 source.setUseCodeAsDefaultMessage(true);
	 source.setCacheSeconds(10);
	 Properties properties=new Properties();
	 properties.setProperty("classpath:messages", "UTF-8");
	 source.setFileEncodings(properties);
	 source.setBasenames("classpath:messages");
	 return  source;
 }
@Bean
public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
	SpringTemplateEngine templateEngine=new SpringTemplateEngine();
	SpringSecurityDialect dialect=new SpringSecurityDialect();
	templateEngine.setTemplateResolver(templateResolver);
	templateEngine.addDialect(dialect);

	return templateEngine;
	
}
@Bean
public ITemplateResolver templateResolver() {
	AbstractConfigurableTemplateResolver templateResolver=new SpringResourceTemplateResolver();
 templateResolver.setTemplateMode("HTML5");
    templateResolver.setPrefix("/WEB-INF/views/");
    templateResolver.setSuffix(".html");
    templateResolver.setCharacterEncoding("utf-8");
    templateResolver.setOrder(1);

    templateResolver.setCacheable(false);
    return templateResolver;



	
}
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setCharacterEncoding("UTF-8");

 
		return viewResolver;
		//return new TilesViewResolver();
//		InternalResourceViewResolver resolver=
//				new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		resolver.setExposeContextBeansAsAttributes(true);
//		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//		return resolver;	
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	
	 @Bean
     public MultipartResolver multipartResolver() throws IOException{
    	 
    	 return new StandardServletMultipartResolver();
     }


	
}
