package edu.bionic.com.P563MerchantXML;

import java.util.List;

public interface PaymentService {
	public List<Payment> findByMerchantId(int id);

	public double getPaymentSum();

	public List<Payment> getLargePayments(double limit);

	public Payment findById(int id);

}