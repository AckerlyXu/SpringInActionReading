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
		//��spring security��������ڸ�������
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
	
	//���ù�����
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter c = new CharacterEncodingFilter();
		c.setEncoding("UTF-8");
		c.setForceEncoding(true);
       OpenSessionInViewFilter openSessionInViewFilter=new OpenSessionInViewFilter();
       
		return new Filter[] {c,openSessionInViewFilter};  
	}

	
	//�����ļ��ϴ�λ��
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub

	            
		registration.setMultipartConfig(new MultipartConfigElement("/tmp"));

	}
    

 

}
