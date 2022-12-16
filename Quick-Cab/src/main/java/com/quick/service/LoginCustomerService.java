package com.quick.service;

import com.quick.exceptions.*;
import com.quick.model.LoginCustomer;

public interface LoginCustomerService {

	public String Customerlogin(LoginCustomer cxlogin) throws CustomerException;
	
	public String Customerlogout(String key) throws CustomerException;
}
