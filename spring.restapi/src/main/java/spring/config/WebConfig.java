package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@ComponentScan(basePackages="spring")
@EnableWebMvc
public class WebConfig
extends WebMvcConfigurerAdapter{
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager manager) {
    ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
    contentNegotiatingViewResolver.setContentNegotiationManager(manager);
    return contentNegotiatingViewResolver;
    }

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
	}
    
}
