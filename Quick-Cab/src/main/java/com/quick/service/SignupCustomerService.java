package com.quick.service;

import com.quick.exceptions.*;
import com.quick.model.*;

public interface SignupCustomerService {

	public Customer signupCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer,String key) throws CustomerException;
}
