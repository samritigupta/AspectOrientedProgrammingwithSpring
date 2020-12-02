package com.springmvclearn.aoparoundadvice;

import java.util.logging.Logger;

import com.springmvclearn.aoparoundadvice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
to resolve print order issue
------------------------------
cause: data is printing in two different output stream, spring is printing in logger output stream and
       SOP is printing in standard output stream.
Solution: use same output stream.
private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName()); -> define logger in both class
and use it to print information.
 */
public class AroundWithLoggerDemoApp {

	private static Logger myLogger = 
					Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
			
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}

}










