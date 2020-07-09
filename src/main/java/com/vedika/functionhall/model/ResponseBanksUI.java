package com.vedika.functionhall.model;

import java.util.Set;

public class ResponseBanksUI {
	private Set<String> bankDetails;

	public Set<String> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(Set<String> bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "ResponseBankName [bankDetails=" + bankDetails + "]";
	}

}
