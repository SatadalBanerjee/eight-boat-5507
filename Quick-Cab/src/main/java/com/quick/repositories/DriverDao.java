package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quick.model.Driver;

import java.util.List;



public interface DriverDao extends JpaRepository<Driver, Integer>{

    @Query("from Driver where rating >= 4.5")
	public List<Driver> getTheBestDrivers();
	
}
