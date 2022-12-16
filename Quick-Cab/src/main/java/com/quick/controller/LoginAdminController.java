package com.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.AdminException;
import com.quick.model.LoginAdmin;
import com.quick.service.LoginAdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginAdminController {

	@Autowired
	private LoginAdminService loginAdminservice;

	@PostMapping("/admin/login")
	public String AdminLoginHandler(@RequestBody LoginAdmin la) throws AdminException {
		return loginAdminservice.Adminlogin(la);
		
	}
	
	@DeleteMapping("/admin/logout")
	public String AdminLogoutHandler(@RequestParam String key )throws AdminException {
		
	return 	loginAdminservice.Adminlogout(key);
		
	}
}
