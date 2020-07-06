package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Bank;
@Repository
public interface BankRespository extends MongoRepository<Bank, String> {

	@Query(value=" {'bankdetails.branch': ?0}", fields="{'bankdetails.$': 1}")

	List<Bank> findbybank(String branch);


	@Query(value = "{'bankdetails.bankname' : ?0,'bankdetails.branch':?1}",fields="{'bankdetails.$':1}")

	List<Bank> findbyBranchAndBank(String bankname, String branch);
}
