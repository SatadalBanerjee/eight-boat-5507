package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quick.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

}
