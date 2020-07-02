package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Bank;
@Repository
public interface BankRespository extends MongoRepository<Bank, String> {

	 @Query(value=" {'Sheet1.branch': ?0}", fields="{'Sheet1.$': 1}")
	 
	List<Bank> findbybank(String branch);
}
