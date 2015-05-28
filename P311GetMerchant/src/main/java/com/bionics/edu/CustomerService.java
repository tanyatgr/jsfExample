package com.bionics.edu;

public interface CustomerService {
	
	public Customer findById(int id);

	public void save(Customer customer);

	public void remove(int id);
	
	public void updateCcNo(int id, String ccNo);

}
