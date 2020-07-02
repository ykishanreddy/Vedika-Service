package com.vedika.functionhall.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "banksdetails")
public class Bank {
	
	    @Id
	    private String _id;
	    
	   
	List<BankDetails> Sheet1;


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public List<BankDetails> getSheet1() {
		return Sheet1;
	}


	public void setSheet1(List<BankDetails> sheet1) {
		Sheet1 = sheet1;
	}
	   
}
