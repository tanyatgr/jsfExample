package com.bionic.edu;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class MerchantList {
	private List<Merchant> merchants;
	
	public MerchantList(){
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
