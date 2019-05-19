package spring.mbean.config;



import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.NotificationListener;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Value;

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
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import spring.mbean.model.MBeanTest;
import spring.mbean.model.MbeanTestNotificationListner;







@Configuration

@ImportResource("classpath:mbean.xml")
@ComponentScan(
		basePackages= {"spring.mbean"},
		excludeFilters= {
				@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
				
		}
		)


public class RootConfig {

	
	@Bean
	public MBeanExporter mBeanExporter(//MBeanTest mBeanTest,
			InterfaceBasedMBeanInfoAssembler assembler) {
		MBeanExporter exporter=new MBeanExporter();
		/*Map<String, Object> beans=new HashMap<>();
		beans.put("mbeanTest:name=test", new MBeanTest());
            exporter.setBeans(beans);
	*/
	
		Map<String, NotificationListener>map=
				new HashMap<>();
		map.put("mbeanTest:name=test",new MbeanTestNotificationListner());
		exporter.setNotificationListenerMappings(map);
		return exporter;
		
	}
	@Bean
	public MethodNameBasedMBeanInfoAssembler assembler() {
		MethodNameBasedMBeanInfoAssembler assembler=new MethodNameBasedMBeanInfoAssembler();
		assembler.setManagedMethods(new String[] {"getAddress","setAddress"});
		return assembler;
		
	}
	@Bean
	public MethodExclusionMBeanInfoAssembler eassembler () {
		MethodExclusionMBeanInfoAssembler assembler=new MethodExclusionMBeanInfoAssembler();
		assembler.setIgnoredMethods(new String[] {"getAddress","setAddress"});
		return assembler;
	}
	@Bean
	public InterfaceBasedMBeanInfoAssembler infoAssembler() {
		InterfaceBasedMBeanInfoAssembler assembler=new InterfaceBasedMBeanInfoAssembler();
		assembler.setManagedInterfaces(new Class<?>[] {MbeanTest.class});
		return assembler;
	}
	//注册connectorServerFactoryBean,并设置远程访问地址
//	@Bean
//	public ConnectorServerFactoryBean connectorServerFactoryBean() {
//		
//		 ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
//		 connectorServerFactoryBean.setServiceUrl("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
//		 return connectorServerFactoryBean;
//	}
	//生成rmi注册表以供connectorServerFactoryBean注册
//	@Bean
//	public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
//		RmiRegistryFactoryBean rmiRegistryFactoryBean=new RmiRegistryFactoryBean();
//		rmiRegistryFactoryBean.setPort(9999);
//	return rmiRegistryFactoryBean;
//	}
	
	/*@Bean
	public MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean() throws Exception {
		
		MBeanServerConnectionFactoryBean connectorServerFactoryBean = new MBeanServerConnectionFactoryBean();
		 connectorServerFactoryBean.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:9999/jmxrmi");
		 return connectorServerFactoryBean;
	}*/
	/*@Bean
	public MBeanProxyFactoryBean remoteSpittleControllerMBean(
			MBeanServerConnection mBeanServerConnection
			
			) throws MalformedObjectNameException {
		MBeanProxyFactoryBean proxyFactoryBean=new MBeanProxyFactoryBean();
		proxyFactoryBean.setObjectName("mbeanTest:name=test");
		proxyFactoryBean.setServer(mBeanServerConnection);
		proxyFactoryBean.setProxyInterface(MbeanTest.class);
		return proxyFactoryBean;
	}*/
	

}
