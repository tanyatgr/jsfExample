package com.bionic.edu;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MerchantList {
	private List<Merchant> merchants;

	public MerchantList() {
		merchants = new ArrayList<Merchant>();
	}

	@XmlElementWrapper(name = "merchantList")
	@XmlElement(name = "merchant", type = Merchant.class)
	public List<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}
}
