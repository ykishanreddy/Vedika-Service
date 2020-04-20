package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.Owner;

public interface OwnerRepository extends MongoRepository<Owner, String> {

 
 List<Owner> findAllByOrderById();

}