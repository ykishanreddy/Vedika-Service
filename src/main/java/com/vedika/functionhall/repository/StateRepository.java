package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vedika.functionhall.model.Data;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.States;

public interface StateRepository extends MongoRepository<Details, String> {

	Details save(Details details);

	@Query(value = "{ 'data.states.state' : ?0 }")
	List<Details> findByState(String state);

	List<Details> findAll();

}
