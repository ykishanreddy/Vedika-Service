package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishListing;

@Service
public interface OwnerService {

	List<Owner> findAll();

	Owner saveOrUpdatePublishListing(PublishListing publishListing);

	List<Owner> findFunctionHallByNameAndCity(String city, String name);

	void update(String corelationid, String imageUrl) throws FileNotFoundException, RuntimeException;

	List<Owner> sendOTP(String mobileNumber);

	boolean send2FaCode(String mobileNumber, String twoFaCode);

}