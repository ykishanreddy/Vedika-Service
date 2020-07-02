package com.vedika.functionhall.model;

import java.util.List;

public class ResponseBankdetails {
	private List<Responsebank> bankdetails;

	public List<Responsebank> getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(List<Responsebank> bankdetails) {
		this.bankdetails = bankdetails;
	}

	@Override
	public String toString() {
		return "ResponseBankdetails [bankdetails=" + bankdetails + "]";
	}

}
