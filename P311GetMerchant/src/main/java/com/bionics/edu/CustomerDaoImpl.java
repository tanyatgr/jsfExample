package com.bionics.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;

	public Customer findById(int id) {
		Customer c = null;
		c = em.find(Customer.class, id);
		return c;
	}

	public void save(Customer customer) {
		em.persist(customer);

	}

	public void remove(int id) {
		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			em.remove(customer);
		}

	}

	public void updateCcNo(int id, String ccNo) {
		Customer customer = em.find(Customer.class, id); // помесить в контекст ентити менеджера
		if(customer!=null){
			customer.setCcNo(ccNo);
		}
		
	}

}
