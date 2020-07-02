package com.vedika.functionhall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.repository.BankRespository;

@Service
public class BankServiceImple implements BankService {

	@Autowired
    BankRespository bankrepository;
	@Override
	public List<Bank> findbybank(String branch) {
		// TODO Auto-generated method stub
		
		
		
		return bankrepository.findbybank( branch);
	}

}
