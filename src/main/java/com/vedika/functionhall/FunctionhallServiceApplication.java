package com.vedika.functionhall;


import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class FunctionhallServiceApplication {
	
	@GetMapping("/login")
	public String google(Principal principal) {
		Map<String,Object> user =(Map<String,Object>)
				((OAuth2Authentication) principal).getUserAuthentication().getDetails();
	  
		String email=(String)user.get("email");
		return "Hi"  + email + "Welcome to My application";
	}
	public static void main(String[] args) {
		SpringApplication.run(FunctionhallServiceApplication.class, args);
	}
	

}


