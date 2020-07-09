package com.vedika.functionhall.model;

public class PublishListing {
	private BankDetails bankDetails;
	private Owner owner;
	private ResponseObject responseObject;
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public ResponseObject getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(ResponseObject responseObject) {
		this.responseObject = responseObject;
	}
	@Override
	public String toString() {
		return "PublishListing [bankDetails=" + bankDetails + ", owner=" + owner + ", responseObject=" + responseObject
				+ "]";
	}
		
}
