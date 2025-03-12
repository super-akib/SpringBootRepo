package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import sbean.Event;
import sbean.EventService;

public class TestInjection 
{
     public static void main(String args[])
     {
    	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	 Event event = ctx.getBean(Event.class);
    	 EventService.eventDetail(event);
    	 
    	 ctx.close();
     }
}  
