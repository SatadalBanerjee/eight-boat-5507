package com.quick.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.*;
import com.quick.model.*;
import com.quick.repositories.AdminDao;
import com.quick.repositories.UserSessionDao;

	@Service
	public class SignupCustomerServiceImpl implements SignupCustomerService{
	
		@Autowired
		private CustomerDao customerDao;
		
		
		@Autowired
		private UserSessionDao userSessionDao;
		
		@Override
		public Customer signupCustomer(Customer customer) {
			
			Customer cust = customerDao.save(customer);
			
			return cust;
		}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		Optional<UserSession> opt=	userSessionDao.findByuid(key);
		
		if(opt.isPresent()) {
			
			return customerDao.save(customer);
			
		}
		
		else {
			
			throw new AdminException("Customer is not logged in");
		}
	}

}
