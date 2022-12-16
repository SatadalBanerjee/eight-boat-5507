package com.quick.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quick.model.Cab;



public interface CabDao extends JpaRepository<Cab, Integer > {

	
	@Query("Select c From Cab c where carType=?1")
	public List<Cab> viewCabOftype(String cartype);
	

}
