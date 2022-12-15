package com.quick.service;

import com.quick.model.LoginAdmin;
import com.quick.exceptions.AdminException;

public interface LoginAdminService {

	public String Adminlogin(LoginAdmin la) throws AdminException;
	
	public String Adminlogout(String key) throws AdminException;
}
