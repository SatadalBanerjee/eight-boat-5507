package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quick.model.LoginAdmin;

public interface LoginAdminDao extends JpaRepository<LoginAdmin, Integer>{

}
