package spring.mbean.web;


import java.io.IOException;
import java.util.Set;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MBeanTestController {
/*@Autowired
@Qualifier("mBeanServerConnectionFactoryBean")*/
MBeanServerConnection service;
	  @RequestMapping("/")
	  public String test() throws Exception {
		  int mbeanCount=service.getMBeanCount();
		  
		  System.out.println("count:"+mbeanCount);
		  Set<ObjectName> queryNames = service.queryNames(null, null);
		  queryNames.stream().forEach(System.out::println);
		  
		  service.setAttribute(new ObjectName("mbeanTest:name=test"),new Attribute("Name","Name"));
		String name=(String)  service.getAttribute(new ObjectName("mbeanTest:name=test"), "Name");
		//  service.invoke(new ObjectName("mbeanTest:name=test"),"method",new Object[] {"name",12},new String[] {"java.lang.String","int"});
		  
		return "ok";
	  }
}
