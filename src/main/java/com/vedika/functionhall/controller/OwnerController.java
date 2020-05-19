package com.vedika.functionhall.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/login")
	public String google(Principal principal) {
		Map<String,Object> user =(Map<String,Object>)
				((OAuth2Authentication) principal).getUserAuthentication().getDetails();
	  
		String email=(String)user.get("email");
		return "Hi"  + email + "Welcome to My application";
	}
     
	@GetMapping(value = "/functionhalls")
	public Response getAllFunctionHalls() {


		List<Owner> functionhallOwners = ownerService.findAll();

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
		
		Response response = new Response();
		response.setFunctionHalls(functionhallsUI);
		return response;
	}


	

}
