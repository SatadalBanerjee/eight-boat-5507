package com.quick.service;
import java.util.List;

import com.quick.exceptions.DriverException;
import com.quick.model.Driver;


public interface DriverService {
	
	public Driver insertDriver(Driver driver)throws DriverException;
	
	public Driver updateDriver(Driver driver)throws DriverException;
	
	public Driver deleteDriver(Integer driverId)throws DriverException;
	
	public List<Driver> viewBestDrivers()throws DriverException;
	
	public Driver viewDrivers(Integer driverId)throws DriverException;

}
