package edu.bionic.com.P563MerchantXML;

import java.util.List;

public interface MerchantDao {
	public Merchant findById(int id);
	public List<Merchant> findAll();
	public List<Merchant> getSortedByNeedToPay();
	public List<Result> getTotalReport();
	public void save(Merchant m);
}
