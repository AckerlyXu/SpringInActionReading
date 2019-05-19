package spittr.config;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

import javax.servlet.ServletRegistration.Dynamic;


import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		//将spring security配置类放在根作用域
		return new Class<?>[] {RootConfig.class,SecurityConfig.class,MethodSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	//设置过滤器
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter c = new CharacterEncodingFilter();
		c.setEncoding("UTF-8");
		c.setForceEncoding(true);
       OpenSessionInViewFilter openSessionInViewFilter=new OpenSessionInViewFilter();
       
		return new Filter[] {c,openSessionInViewFilter};  
	}

	
	//设置文件上传位置
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub

	            
		registration.setMultipartConfig(new MultipartConfigElement("/tmp"));

	}
    

 

}
