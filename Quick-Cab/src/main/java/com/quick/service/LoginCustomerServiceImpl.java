package com.quick.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.*;
import com.quick.model.*;
import com.quick.model.*;
import com.quick.model.*;
import com.quick.repositories.*;

import io.swagger.v3.oas.annotations.servers.Server;

import com.quick.repositories.*;
import com.quick.repositories.*;

@Service
public class LoginCustomerServiceImpl implements LoginCustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private LoginCustomerDao customerLoginDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	
	@Override
	public String Customerlogin(LoginCustomer la) throws CustomerException {
		
		
		Customer customer= customerDao.findById(la.getUserId()).orElseThrow(()->new CustomerException("User Id not find"));
		
		if(!customer.getUsername().equals(la.getName())) {

			return "Please check the username";
		}
		if(!customer.getPassword().equals(la.getPassword())) {

			return "Please check the password";
		}
		
		
		Optional<UserSession> opt = userSessionDao.findByuserId(la.getUserId());
		
		if(opt.isPresent()) {	
			
			return "Customer Alredy logged in";
		}
		
	 	RandomNumber ran = new RandomNumber();
			
	 	String uuid=ran.RandomNum();
			
	 	UserSession cus= new UserSession();
	 	
		cus.setUserId(la.getUserId());
		cus.setLocalDateTime(LocalDateTime.now());
		cus.setUUid(uuid);
			
		customerLoginDao.save(la);
		
		UserSession cs=	userSessionDao.save(cus);
		
		return cs.toString();
	}

	@Override
	public String Customerlogout(String key) throws CustomerException {
		
		UserSession cus=	userSessionDao.findByuUid(key).orElseThrow(()-> new CustomerException("Enter correct Key"));

		customerLoginDao.deleteById(cus.getUserId());
		userSessionDao.delete(cus);	
		
		return "Logout Successful";
	}

}
