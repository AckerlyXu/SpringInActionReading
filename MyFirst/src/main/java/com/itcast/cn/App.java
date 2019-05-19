package com.itcast.cn;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.service.AopJavaConfig;
import com.spring.aop.service.Performance;
import com.spring.aop.service.impl.Performance1;
import com.spring.aop.service.impl.TrackCounter;
import com.spring.di.CDPlayerConfig;
import com.spring.di.config.SoundsSystemConfig;
import com.spring.di.service.CompactDisc;
import com.spring.di.service.impl.CDPlayer;
import com.spring.di.service.impl.Cake;
import com.spring.di.service.impl.SgtPeppers;

public class App {
           

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("aopconfig.xml");
         Performance performance1=    (Performance)context.getBean("perform");
                    
         performance1.perform();
       CompactDisc disc=  (CompactDisc)context.getBean("sgtPeppers");
       disc.playTrack(1);;
     TrackCounter counter=  (TrackCounter)context.getBean("trackCounter");
             System.out.println(counter.getPlayCount(1));   
//         CDPlayer con=    (CDPlayer)context.getBean("hello");
//         con.getCompactDisc().play();
//     con.Action();
          AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopJavaConfig.class);
          ;
         // SgtPeppers cake= (SgtPeppers)annotationConfigApplicationContext.getBean("setPeppers");
         // cake.play();
    	 

          

        
	}

}
