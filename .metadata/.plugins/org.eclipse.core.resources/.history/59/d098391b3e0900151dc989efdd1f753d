package com.bionic.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMerchant {
	@SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("client-beans.xml");
        MerchantWS service = context.getBean(MerchantWS.class);
        String result = service.getMerchantList();
        System.out.println(result);
    }

}
