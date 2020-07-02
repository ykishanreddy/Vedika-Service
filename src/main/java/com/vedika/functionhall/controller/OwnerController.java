package com.vedika.functionhall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.Amazonresponse;
import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.BankDetails;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Object;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.model.ResponseBankdetails;
import com.vedika.functionhall.model.Responsebank;
import com.vedika.functionhall.service.AmazonClient;
import com.vedika.functionhall.service.BankService;
import com.vedika.functionhall.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class OwnerController {

	private AmazonClient amazonClient;

	@Autowired
	OwnerController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private BankService bankservice;

	@RequestMapping(value = "/functionhalls/", method = RequestMethod.GET)
	public Response getAllFunctionHalls() {

		List<Owner> functionhallOwners = ownerService.findAll();

		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();

						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreet());
						response.setState(functionHall.getState());
						response.setZipcode(functionHall.getZipcode());
						response.setImageUrl(functionHall.getImageUrl());
						response.setCorelationid(functionHall.getCorelationId());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						functionhallsUI.add(response);
					}
				}
			}

		}

		Response response = new Response();
		response.setFunctionHalls(functionhallsUI);
		return response;
	}

	@RequestMapping(value = "/functionhallsBy/", method = RequestMethod.GET)

	public Response findFunctionhallByNameAndCity(@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "name", required = false) String name) {

		List<Owner> functionhallOwners = ownerService.findFunctionHallByNameAndCity(city, name);

		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();
						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreet());
						response.setState(functionHall.getState());
						response.setZipcode(functionHall.getZipcode());
						response.setImageUrl(functionHall.getImageUrl());
						response.setCorelationid(functionHall.getCorelationId());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						functionhallsUI.add(response);
					}
				}
			}

		}

		Response response = new Response();
		response.setFunctionHalls(functionhallsUI);
		return response;
	}

	@RequestMapping(value = "/user/verification", method = RequestMethod.POST)
	public Object sendOTP(@RequestParam String mobileNumber, @RequestBody Object response1) {
		Object res = new Object();
		res.setRequestId(res.getRequestId());
		res.setMobileNumber(res.getMobileNumber());
		res.setMessage(res.getMessage());
		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		ownerService.send2FaCode(mobileNumber, twoFaCode);
		return response1;
	}

	@RequestMapping(value = "user/verification", method = RequestMethod.PUT)
	public ResponseEntity<?> verify(@RequestParam String mobileNumber) {

		boolean isValid = true;

		if (isValid)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(value = "/functionhalls")
	public ResponseEntity<?> saveOrUpdateOwner(@RequestBody Owner owner) {
		ownerService.saveOrUpdateOwner(owner);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/image/", method = RequestMethod.POST)

	public Amazonresponse image(@RequestParam(value = "file") MultipartFile file, String corelationid)
			throws IOException {

		Amazonresponse response = new Amazonresponse();
		response.setMsg(" uploading request submitted successfully.");

		String imageUrl = amazonClient.uploadFile(file, corelationid);

		ownerService.update(corelationid, imageUrl);

		return response;
	}
	@GetMapping("/bankdetails")
	public ResponseBankdetails  getBank(@RequestParam(value = "branch") String branch) {
		
		List<Bank> response=bankservice.findbybank(branch);

		List<Responsebank> functionhallsUI = new ArrayList<Responsebank>();
		if (null != response && !response.isEmpty()) {
			for (Bank owner : response) {
				
				List<BankDetails> funtionhalls = owner.getSheet1();
				if (null != funtionhalls && !funtionhalls.isEmpty()) {
					for (BankDetails functionHall : funtionhalls) {
			
		
	             	  
	        	Responsebank response1=new Responsebank();
	        	
	        	response1.setId(owner.get_id());
	        	response1.setAddress(functionHall.getAddress());
	        	response1.setBankname(functionHall.getBankname());
	        	response1.setBranch(functionHall.getBranch());
	        	response1.setCity(functionHall.getCity());
	        	response1.setIfsc(functionHall.getIfsc());
	        	response1.setContact(functionHall.getContact());
	        	response1.setState(functionHall.getState());
	        	response1.setDistrict(functionHall.getDistrict());
	        	functionhallsUI.add(response1);
	        	System.out.println(response1);
	        	  
	        	 	
	        	
					}}}
				}
		ResponseBankdetails res=new ResponseBankdetails();
		res.setBankdetails(functionhallsUI);
		
		
		return res;
		
			
			
		}
}



