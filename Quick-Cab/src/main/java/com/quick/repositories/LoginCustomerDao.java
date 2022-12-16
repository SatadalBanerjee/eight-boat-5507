package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quick.model.LoginCustomer;

public interface LoginCustomerDao extends JpaRepository<LoginCustomer, Integer>{

}
