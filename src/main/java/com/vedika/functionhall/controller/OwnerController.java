package com.vedika.functionhall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class OwnerController {
	
	
	@Autowired
	private OwnerService ownerService;
  
	  @GetMapping(value = "/functionhalls")
 
	public Response getAllFunctionHalls( )
 {
        

		List<Owner> functionhallOwners = ownerService.findAll();
		
		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for(Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if(null != funtionhalls && !funtionhalls.isEmpty()) {

					for(FunctionHall functionHall : funtionhalls) {

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

/*

		@GetMapping("/functionhallbycity/")
		@ResponseBody
		public ResponseForCity  getByFunctionhalls( 
	            @RequestParam( value="city" ,required=false) String city) {
			
		
			List<Owner> functionhallOwners = ownerService.findFunctionHallByCity( city);

			List<ResponsefindByCityfunctionhall> functionhallsUI = new ArrayList<ResponsefindByCityfunctionhall>();

			if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
				for(Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhall = owner.getFunctionhall();

					if(null != funtionhall && !funtionhall.isEmpty()) {

						for(FunctionHall functionHall : funtionhall) {
							ResponsefindByCityfunctionhall response = new ResponsefindByCityfunctionhall();
							response.setId(owner.getId());
							response.setFunctionHallName(functionHall.getName());
							response.setCity(functionHall.getCity());
	                        response.setStreet(functionHall.getStreet());
	                        response.setState(functionHall.getState());
	                        response.setZipcode(functionHall.getZipcode());

							functionhallsUI.add(response);
						}
					}
				}

			}
			
			ResponseForCity response = new ResponseForCity();
			response. setFunctionHalls(functionhallsUI);
			return response;


		 
		}	



	
		@GetMapping("/functionhallbyname/")
		@ResponseBody
		public ResponseForCity  getByFunctionhallName( 
	            @RequestParam( value="name" ,required=false) String name) {
			
		
			List<Owner> functionhallOwners = ownerService.findFunctionHallByName(name);

			List<ResponsefindByCityfunctionhall> functionhallsUI = new ArrayList<ResponsefindByCityfunctionhall>();

			if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
				for(Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhall = owner.getFunctionhall();

					if(null != funtionhall && !funtionhall.isEmpty()) {

						for(FunctionHall functionHall : funtionhall) {
							ResponsefindByCityfunctionhall response = new ResponsefindByCityfunctionhall();
							
							response.setId(owner.getId());
							response.setFunctionHallName(functionHall.getName());
							response.setCity(functionHall.getCity());
	                        response.setStreet(functionHall.getStreet());
	                        response.setState(functionHall.getState());
	                        response.setZipcode(functionHall.getZipcode());

							functionhallsUI.add(response);
						}
					}
				}

			}
			
			ResponseForCity response = new ResponseForCity();
			response. setFunctionHalls(functionhallsUI);
			return response;
 
		}	
		
		  
	  
	*/
	  

		@GetMapping("functionhallsfindbyname/" )
		@ResponseBody
		public Response   findFunctionhallByName( 
	            @RequestParam( value="name" ,required=false) String name) {
	  

	        

			List<Owner> functionhallOwners = ownerService.findFunctionHallByName(name);

			List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

			if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
				for(Owner owner : functionhallOwners) {

					List<FunctionHall> funtionhalls = owner.getFunctionhall();

					if(null != funtionhalls && !funtionhalls.isEmpty()) {

						for(FunctionHall functionHall : funtionhalls) {

							FunctionHallUIResponse response = new FunctionHallUIResponse();
							response.setOwnerFirstName(owner.getFirstName());
							response.setOwnerLastName(owner.getLastName());
							response.setOwnerId(owner.getId());

							response.setName(functionHall.getName());
							response.setCity(functionHall.getCity());
	                        response.setStreet(functionHall.getStreet());
	                        response.setState(functionHall.getState());
	                        response.setZipcode(functionHall.getZipcode());

							functionhallsUI.add(response);
						}
					}
				}

			}
			
			Response response = new Response();
			response.setFunctionHalls(functionhallsUI);
			return response;
		}

		
		


		@GetMapping("/functionhallsfindbycity/")
		@ResponseBody
		public Response   getFunctionhall( 
	            @RequestParam( value="city" ,required=false) String city) {
	  

	        

			List<Owner> functionhallOwners = ownerService.findFunctionHallByCity(city);

			List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

			if(null != functionhallOwners && !functionhallOwners.isEmpty()) {
				for(Owner owner : functionhallOwners) {

					List<FunctionHall> funtionhalls = owner.getFunctionhall();

					if(null != funtionhalls && !funtionhalls.isEmpty()) {

						for(FunctionHall functionHall : funtionhalls) {

							FunctionHallUIResponse response = new FunctionHallUIResponse();
							
							response.setName(functionHall.getName());
							response.setOwnerFirstName(owner.getFirstName());
							response.setOwnerLastName(owner.getLastName());
							response.setOwnerId(owner.getId());

							
							response.setCity(functionHall.getCity());
	                        response.setStreet(functionHall.getStreet());
	                        response.setState(functionHall.getState());
	                        response.setZipcode(functionHall.getZipcode());

							functionhallsUI.add(response);
						}
					}
				}

			}
			
			Response response = new Response();
			response.setFunctionHalls(functionhallsUI);
			return response;
		}
		
		
		@PostMapping(value = "/functionhalls")
	    public ResponseEntity<?> saveOrUpdateOwner(@RequestBody Owner owner) {
	        ownerService.saveOrUpdateOwner(owner);
	        return new ResponseEntity("functionhall details added successfully", HttpStatus.OK);
	    }
	 
		
}

