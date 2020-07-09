package com.vedika.functionhall.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "banksdetails")
public class Bank {

	@Id
	private String _id;

	List<BankDetails> data;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<BankDetails> getData() {
		return data;
	}

	public void setData(List<BankDetails> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Bank [_id=" + _id + ", data=" + data + "]";
	}

}
