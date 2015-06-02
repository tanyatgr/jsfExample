package com.bionics.edu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class PaymentServiceImpl implements PaymentService {
	@Inject
	private PaymentDao paymentDao;
	
	@Inject
	private CustomerService customerService;

	public List<Payment> findByMerchantId(int id) {
		return paymentDao.findByMerchantId(id);
	}

	public double getPaymentSum() {

		return paymentDao.getPaymentSum();
	}

	public List<Payment> getLargePayments(double limit) {
		return paymentDao.getLargePayments(limit);
	}

	public Payment findById(int id) {
		return paymentDao.findById(id);
	}	


}