package com.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.AdminException;
import com.quick.model.Admin;
import com.quick.service.SignupAdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SignupAdminController {

	@Autowired
	private SignupAdminService signupAdminservice;
	
	@PostMapping("/admin/signup")
	public ResponseEntity<Admin> CreateAdmin(@RequestBody Admin admin) {
		
		Admin adm = signupAdminservice.signupAdmin(admin);
		
		return new ResponseEntity<Admin>(adm,HttpStatus.OK);
		
	}
	
	@PutMapping("/admin/update")
	public Admin UpdateAdmin(@RequestBody Admin admin,@RequestParam String key) throws AdminException {
		
		return signupAdminservice.updateAdmin(admin, key);
	}
}
