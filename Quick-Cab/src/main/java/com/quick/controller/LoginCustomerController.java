package com.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quick.exceptions.*;
import com.quick.model.LoginCustomer;
import com.quick.service.LoginCustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginCustomerController {

	@Autowired
	private LoginCustomerService loginCustomerService;
	
	@PostMapping("/customer/login")
	public String customerLoginHandler(@RequestBody LoginCustomer loginCust) throws CustomerException {
		
		return loginCustomerService.Customerlogin(loginCust);
		 
	}
	
	@DeleteMapping("/customer/logout")
	public String customerLogoutHandler(@RequestParam String key )throws  CustomerException {
		
	return loginCustomerService.Customerlogout(key);
		
	}
	
	
}
