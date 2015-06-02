package com.bionics.edu;

import java.util.List;

public interface MerchantService {
	public Merchant findById(int id);
	public List<Merchant> findAll();
	public List<Merchant> getSortedByNeedToPay();
	public List<Result> getTotalReport();

}
