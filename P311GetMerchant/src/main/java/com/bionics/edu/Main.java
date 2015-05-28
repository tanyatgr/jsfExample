package com.bionics.edu;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		/*
		 * MerchantService merchantService = context
		 * .getBean(MerchantService.class); Merchant m1 =
		 * merchantService.findById(1); System.out.println("name = " +
		 * m1.getName());
		 * 
		 * CustomerService customerService = context
		 * .getBean(CustomerService.class); Customer c1 =
		 * customerService.findById(1); System.out.println(c1.toString());
		 */

		CustomerService customerService = context
				.getBean(CustomerService.class);
		/*
		 * Customer customer = new Customer();
		 * customer.setAddress("Independence st. 21, Malaga, 	Spane");
		 * customer.setCcNo("11122233344488");
		 * customer.setCcType("Master Card"); customer.seteMail("vera@s.com");
		 * LocalDate dt = LocalDate.of(2017, Month.FEBRUARY, 28);
		 * customer.setMaturity(java.sql.Date.valueOf(dt));
		 * customer.setName("Vera Po"); customerService.save(customer);
		 * System.out.println("id = " + customer.getId());
		 */

		customerService.remove(4);
	}
}
