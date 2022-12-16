package com.quick.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.CustomerException;
import com.quick.model.Customer;
import com.quick.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@PostMapping("/registercustomer")
	public ResponseEntity<Customer> regCustomerHandler(@Valid @RequestBody Customer cust) throws CustomerException {
		Customer customer = cService.insertCustomer(cust);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer cust) throws CustomerException {
		Customer updatecust = cService.updateCustomer(cust);

		return new ResponseEntity<Customer>(updatecust, HttpStatus.OK);
	}

	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<Customer> deleteCustomerByIdHandler(@PathVariable Integer id) throws CustomerException {
		Customer deletecust = cService.deleteCustomer(id);

		return new ResponseEntity<Customer>(deletecust, HttpStatus.OK);
	}

	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException {
		List<Customer> employees = cService.viewCustomer();

		return new ResponseEntity<List<Customer>>(employees, HttpStatus.OK);
	}

	@GetMapping("/getcustomerbyid/{id}")
	public ResponseEntity<Customer> getEmployeeByAddAndNameHandler(@PathVariable Integer id) throws CustomerException {
		Customer customerdata = cService.viewCustomer(id);

		return new ResponseEntity<Customer>(customerdata, HttpStatus.OK);
	}

}
