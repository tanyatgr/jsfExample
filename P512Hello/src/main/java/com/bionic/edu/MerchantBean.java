package com.bionic.edu;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import java.util.*;

@Named
@Scope("session")
public class MerchantBean {
	private List<Merchant> merchants = null;
	@Inject
	private MerchantService merchantService;

	private Merchant merchant;

	public MerchantBean() {
		merchant = new Merchant();
	}

	public List<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}

	public void refreshList() {
		merchants = merchantService.findAll();
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String saveMerchant() {
		merchantService.save(merchant);
		return "MerchantList";
	}

	public String addMerchant() {
		merchant = new Merchant();
		return "newMerchant";
	}

	public String editMerchant(String id) {
		int n = Integer.valueOf(id);
		merchant = merchantService.findById(n);
		return "newMerchant";
	}

}