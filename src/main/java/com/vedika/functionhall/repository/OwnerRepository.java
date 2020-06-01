package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vedika.functionhall.model.Owner;

public interface OwnerRepository extends MongoRepository<Owner, String> {
	   
	List<Owner> findAll();
	
	
	
	 @Query(value="{ 'functionhall.city' : ?0 }")

	List<Owner> findFunctionHallByCity(String city);


	 @Query(value ="{ 'functionhall.name' : ?0 }")
List<Owner> findFunctionHallByName(String name);

	
	


 

}