package com.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quick.model.*;
import com.quick.service.SignupCustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.quick.exceptions.*;

@RestController
public class SignupCustomerController {

	@Autowired
	private  SignupCustomerService signupCxService;
	
	@PostMapping("/customer/signup")
	public Customer signupCxHandler(@RequestBody Customer customer) {
		 
		return signupCxService.SignupCustomer(customer);
		
	}
	
	@PostMapping("/user/update")
	public Customer UpdateCxHandler(@RequestBody Customer customer,@RequestParam String key) throws CustomerException {
		
		return signupCxService.UpdateCustomer(customer, key);
	}
}
