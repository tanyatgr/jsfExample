package com.bionic.edu;


import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Named
public class Application {
	@Inject
    @Named("helloKittyService")
	GreetingService greeting = null;
	

	public GreetingService getGreeting() {
		return greeting;
	}

	public void setGreeting(GreetingService greeting) {
		this.greeting = greeting;
	}

	public Application() {
	}

	public Application(GreetingService greeting) {
		this.greeting = greeting;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Application application = (Application) ctx.getBean("application");
		application.start();
	}

	public void start() {
		if (greeting != null)
			greeting.sendGreeting();
	}
}
