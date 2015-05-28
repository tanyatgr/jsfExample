package com.bionic.edu;

import javax.inject.Named;

@Named
public class HelloKittyService implements GreetingService {
	public void sendGreeting() {
		System.out.println("Hello, Kitty!");
	}

}
