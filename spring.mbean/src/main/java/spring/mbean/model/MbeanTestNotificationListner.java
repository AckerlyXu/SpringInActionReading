package spring.mbean.model;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;


public class MbeanTestNotificationListner implements NotificationListener {

	@Override
	public void handleNotification(Notification arg0, Object arg1) {
		// TODO Auto-generated method stub
          System.out.println(arg0.toString()+arg1);
	}

}
