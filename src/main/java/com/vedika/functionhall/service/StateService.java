package com.vedika.functionhall.service;


import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.vedika.functionhall.model.Data;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.States;


public interface StateService {
	Details saveOrUpdateOwner(Details details);

	List<Details> findByState(String state);
	List<Details> findAll();





}