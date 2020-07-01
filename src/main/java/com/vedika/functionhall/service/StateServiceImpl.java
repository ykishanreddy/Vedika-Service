package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Data;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.States;
import com.vedika.functionhall.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository; 


	@Override
	public Details saveOrUpdateOwner(Details details) {
		return stateRepository.save(details);
	}


	@Override
	public List<Details> findByState(String state) {			
		return stateRepository.findByState(state);
	}


	@Override
	public List<Details> findAll() {
		return stateRepository.findAll();
	}




}
