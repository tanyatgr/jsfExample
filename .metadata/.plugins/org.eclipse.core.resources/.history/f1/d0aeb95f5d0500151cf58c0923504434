package edu.bionic.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context =  new 	ClassPathXmlApplicationContext("client-beans.xml");
        HelloWorldService service = 	context.getBean(HelloWorldService.class);
        System.out.println(service.sayHello());
    } }