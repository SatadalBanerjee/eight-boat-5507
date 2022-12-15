package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quick.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
