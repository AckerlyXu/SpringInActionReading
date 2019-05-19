package orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("orders.web")
public class WebConfig {
	
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver=
		new InternalResourceViewResolver();
resolver.setPrefix("/WEB-INF/views/");
resolver.setSuffix(".jsp");
resolver.setExposeContextBeansAsAttributes(true);
resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
return resolver;	
		
		
	}
		
}
