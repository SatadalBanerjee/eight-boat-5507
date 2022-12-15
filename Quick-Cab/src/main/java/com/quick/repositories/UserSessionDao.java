package com.quick.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quick.model.UserSession;

public interface UserSessionDao extends JpaRepository<UserSession, Integer> {
	
	public Optional<UserSession>findByuserId(Integer id);
	
	public Optional<UserSession>findByuid(String uid);
}
