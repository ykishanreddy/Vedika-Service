package com.vedika.functionhall.model;

public class AccountDetails {
	private String Country;
	private String currency;
	private String bankname;
	private String accountname;
	private long accountnumber;
	private String ifsccode;
	private String pannumber;
	private String accounttype;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "AccountDetails [Country=" + Country + ", currency=" + currency + ", bankname=" + bankname
				+ ", accountname=" + accountname + ", accountnumber=" + accountnumber + ", ifsccode=" + ifsccode
				+ ", pannumber=" + pannumber + ", accounttype=" + accounttype + "]";
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

}
