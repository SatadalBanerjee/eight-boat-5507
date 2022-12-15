package com.quick.service;

import java.util.List;

import com.quick.exceptions.CustomerException;
import com.quick.model.Customer;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> viewCustomer() throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public Customer validateCustomer(String username, String password) throws CustomerException;

}
