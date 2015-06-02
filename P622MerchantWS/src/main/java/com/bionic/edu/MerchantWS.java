package com.bionic.edu;

import javax.jws.WebService;

@WebService
public interface MerchantWS {
	String getMerchantList();
	Merchant getMerchant(int id);
}
