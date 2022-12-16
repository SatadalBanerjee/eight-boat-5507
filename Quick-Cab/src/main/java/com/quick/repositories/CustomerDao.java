package com.quick.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quick.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	@Query("from Customer")
	public List<Customer> getAllCustomersDetails();
	
}
