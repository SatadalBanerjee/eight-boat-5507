package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quick.exceptions.AdminException;
import com.quick.exceptions.DriverException;
import com.quick.model.Driver;
import com.quick.model.TripBooking;

import java.util.List;


@Repository
public interface DriverDao extends JpaRepository<Driver, Integer>{

    @Query("from Driver where rating >= 4.5")
	public List<Driver> getTheBestDrivers();
    
    
   
	
}
