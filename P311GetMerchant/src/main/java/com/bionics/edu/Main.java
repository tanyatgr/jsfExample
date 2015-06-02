package com.bionics.edu;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * MerchantService merchantService = context
		 * .getBean(MerchantService.class); Merchant m1 =
		 * merchantService.findById(1); System.out.println("name = " +
		 * m1.getName());
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		
		MerchantService merchantService = context.getBean(MerchantService.class); 
		
		PaymentService paymentService = context.getBean(PaymentService.class);

		CustomerService customerService = context.getBean(CustomerService.class);
		
		Customer customer = new Customer();
		customer.setAddress("Independence st. 21, Malaga, 	Spane");
		customer.setCcNo("11122233344488");
		customer.setCcType("Master Card");
		customer.seteMail("vera@s.com");
		LocalDate dt = LocalDate.of(2017, Month.FEBRUARY, 28);
		customer.setMaturity(java.sql.Date.valueOf(dt));
		customer.setName("Vera Po");
		
		Payment payment = new Payment();
		java.util.Date date= new java.util.Date();
		payment.setChargePayed(0.23);
		payment.setDt(new Timestamp(date.getTime()));
		payment.setGoods("goods");
		payment.setSumPayed(500);
		payment.setMerchant(merchantService.findById(1));
		
		ArrayList<Payment> list = new ArrayList<Payment>();
		list.add(payment);
		customer.setPayments(list);
		payment.setCustomer(customer);

		customerService.save(customer);

		

		
		
	}
}
