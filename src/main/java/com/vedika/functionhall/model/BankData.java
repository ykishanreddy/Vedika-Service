package com.vedika.functionhall.model;

public class BankData {

	private ResponseBanksUI data;

	public ResponseBanksUI getData() {
		return data;
	}

	public void setData(ResponseBanksUI data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BankData [data=" + data + "]";
	}

}
