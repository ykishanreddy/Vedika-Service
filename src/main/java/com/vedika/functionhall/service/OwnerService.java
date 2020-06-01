package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.vedika.functionhall.model.Owner;

public interface OwnerService  {

    List<Owner> findAll();
    
    Owner saveOrUpdateOwner(Owner owner);
    @Query(value="{ 'functionhall.city' : ?0 }")
	List<Owner> findFunctionHallByCity(String city);

	   @Query(value ="{ 'functionhall.name' : ?0 }")
	List<Owner> findFunctionHallByName(String name);

	  
 
}