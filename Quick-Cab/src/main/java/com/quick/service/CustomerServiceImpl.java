package com.quick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.quick.exceptions.CustomerException;
import com.quick.model.Customer;
import com.quick.repositories.CustomerDao;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao cdao;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerException {
		
		Customer saveCustomer = cdao.save(customer);
		return saveCustomer;
	}

	
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {

		Optional<Customer> opt = cdao.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
	
			//customer.setTripList(opt.getTripList());
			
			Customer updateCustomer = cdao.save(customer);
			return updateCustomer;
			
		}else {
			throw new CustomerException("Customer details not found to updated the customer");
		}
		
	}
	
	

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Optional<Customer> opt = cdao.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer deleteCustomer = opt.get();
			
			cdao.delete(deleteCustomer);
			
			return deleteCustomer;
			
		}else {
			throw new CustomerException("customer does not exsit with thsi customerId "+customerId);
		}
		
	}
	
	

	@Override
	public List<Customer> viewCustomer() throws CustomerException {
		
		List<Customer> customerList = cdao.getAllCustomersDetails();
		
		if(customerList.isEmpty()) {
			throw new CustomerException("customer not found");
			
		}else {
		
			return customerList;
		}
		
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {

		Optional<Customer> opt = cdao.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer viewCustomer = opt.get();
			return viewCustomer;	
			
		}else {
			throw new CustomerException("coustomer dose not exsit with thsi customer Id "+ customerId);
		}
		
	}

	@Override
	public Customer validateCustomer(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
