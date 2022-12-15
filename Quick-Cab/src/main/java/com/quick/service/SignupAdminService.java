package com.quick.service;

import com.quick.exceptions.AdminException;
import com.quick.model.Admin;

public interface SignupAdminService {

	public Admin signupAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin,String key) throws AdminException;
}
