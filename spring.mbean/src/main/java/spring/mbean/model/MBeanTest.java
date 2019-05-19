package spring.mbean.model;

import javax.management.Notification;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName="mbeanTest:name=test")
@ManagedNotification(notificationTypes="SpittleNotifier.one",name="todo")
public class MBeanTest implements NotificationPublisherAware {

private String name;
private int age;
private String address;
private String email;
private NotificationPublisher notificationPublisher;
@ManagedAttribute
public String getName() {
	return name;
}
@ManagedAttribute
public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}
@ManagedAttribute
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@ManagedOperation
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@ManagedOperation
public void method (String name,int age) {
	notificationPublisher.sendNotification(
			new Notification("SpittleNotifier.one", this,0)
			);
System.out.println(name+":"+age);
}
@Override
public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
	// TODO Auto-generated method stub
	this.notificationPublisher=notificationPublisher;
}
	
}
