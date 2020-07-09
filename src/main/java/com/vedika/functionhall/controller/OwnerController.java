package com.vedika.functionhall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.Amazonresponse;
import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.BankData;
import com.vedika.functionhall.model.BankDetails;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishListing;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.model.ResponseBankdetails;
import com.vedika.functionhall.model.ResponseBanksUI;
import com.vedika.functionhall.model.ResponseObject;
import com.vedika.functionhall.model.Responsebank;
import com.vedika.functionhall.model.StateResponse;
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
						response.setFunctionhalldescription(functionHall.getFunctionhalldescription());
						response.setFunctionhalltype(functionHall.getFunctionhalltype());
						response.setMaximumguest(functionHall.getMaximumguest());
						response.setFoodtype(functionHall.getFoodtype());
						response.setRoomtype(functionHall.getRoomtype());
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
	public ResponseEntity<ResponseObject> sendOTP(@RequestParam String mobileNumber, @RequestBody ResponseObject response1) {
		ResponseObject res = new ResponseObject();
		res.setRequestId(res.getRequestId());
		res.setMobileNumber(res.getMobileNumber());
		res.setMessage(res.getMessage());
		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		ownerService.send2FaCode(mobileNumber, twoFaCode);
		return new ResponseEntity<>(response1,HttpStatus.OK);
	}

	@RequestMapping(value = "user/verification", method = RequestMethod.PUT)
	public ResponseEntity<Object> verify(@RequestParam String mobileNumber) {

		boolean isValid = true;

		if (isValid)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PostMapping(value = "/functionhalls")
	public ResponseEntity<?> saveOrUpdatePublishListing(@RequestBody PublishListing publishListing) {
		ownerService.saveOrUpdatePublishListing(publishListing);
		return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/image/", method = RequestMethod.POST)

	public Amazonresponse image(@RequestParam(value = "file") MultipartFile file, String corelationid)
			throws IOException {
		
		 HttpClient httpclient = new DefaultHttpClient();
         HttpPost httppost = new HttpPost("https://api.constantcontact.com/v2/library/files");
         httppost.addHeader("Content-type", "multipart/form-data");


		Amazonresponse response = new Amazonresponse();
		response.setMsg(" uploading request submitted successfully.");

		String imageUrl = amazonClient.uploadFile(file, corelationid);

		ownerService.update(corelationid, imageUrl);

		return response;
	}

	

	@GetMapping("/bankdetails/")
	public ResponseBankdetails getBank(@RequestParam(value = "bankname") String bank,
			@RequestParam(value = "branch") String branch) {
		List<Bank> response = bankservice.findbyBranchAndBank(bank, branch);
		List<Responsebank> functionhallsUI = new ArrayList<Responsebank>();
		if (null != response && !response.isEmpty()) {
			for (Bank owner : response) {
				List<BankDetails> funtionhalls = owner.getData();
				if (null != funtionhalls && !funtionhalls.isEmpty()) {
					for (BankDetails bankdetails : funtionhalls) {
						Responsebank response1 = new Responsebank();
						response1.setId(owner.get_id());
						response1.setAddress(bankdetails.getAddress());
						response1.setBankname(bankdetails.getBank());
						response1.setBranch(bankdetails.getBranch());
						response1.setCity(bankdetails.getCity());
						response1.setIfsc(bankdetails.getIfsc());
						response1.setContact(bankdetails.getContact());
						response1.setState(bankdetails.getState());
						response1.setDistrict(bankdetails.getDistrict());
						functionhallsUI.add(response1);
					}
				}
			}
		}
		ResponseBankdetails bankdata = new ResponseBankdetails();
		bankdata.setBankdetails(functionhallsUI);
		return bankdata;

	}
	@GetMapping("/branches")
	public BankData getBank(@RequestParam(value = "bank") String bank) {
		Optional<Set<String>> branchNameList = Optional.of(new TreeSet<>());
		List<Bank> response = bankservice.findbybank(bank);
		if (null != response && !response.isEmpty()) {
			for (Bank bankdata : response) {

				List<BankDetails> banklist = bankdata.getData();
				if (null != banklist && !banklist.isEmpty()) {

					for (BankDetails branch : banklist) {
						if (branch.getBranch() != null && !branch.getBranch().isEmpty()
								&& !branchNameList.get().contains(branch.getBranch())) {
							branchNameList.get().add(branch.getBranch());
						}

					}
				}
			}
		}
		ResponseBanksUI branchList = new ResponseBanksUI();
		branchList.setBankDetails(branchNameList.get());
		BankData data = new BankData();
		data.setData(branchList);
		return data;

	}

	@GetMapping("/banks")
	public BankData getBank() {

		Optional<Set<String>> bankNameList = Optional.of(new TreeSet<>());
		List<Bank> banks = bankservice.findAll();
		if (null != banks && !banks.isEmpty()) {
			for (Bank bank : banks) {
				List<BankDetails> details = bank.getData();

				if (null != details && !details.isEmpty()) {

					for (BankDetails bankdata : details) {
						if (bankdata.getBank() != null && !bankdata.getBank().isEmpty()
								&& !bankNameList.get().contains(bankdata.getBank())) {
							bankNameList.get().add(bankdata.getBank());
						}
					}
				}
			}
		}

		ResponseBanksUI banksList = new ResponseBanksUI();
		banksList.setBankDetails(bankNameList.get());
		BankData data = new BankData();
		data.setData(banksList);
		return data;
	}
}


