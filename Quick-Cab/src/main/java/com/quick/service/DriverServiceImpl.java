package com.quick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.quick.exceptions.DriverException;
import com.quick.model.Driver;
import com.quick.repositories.DriverDao;

import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverDao dDao;
	
	
	@Override
	public Driver insertDriver(Driver driver) throws DriverException {
		
		Driver cDriver = dDao.save(driver);	
		return cDriver;
		
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		
		Optional<Driver> opt = dDao.findById(driver.getDriverId());
		
		if(opt.isPresent()) {
			
			Driver upDriver = dDao.save(driver);
//			upDriver
			
			return upDriver;
			
		}else {
			throw new DriverException("Driver details not update");
		}
		
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {
		
		Optional<Driver> opt = dDao.findById(driverId);
		
		if(opt.isPresent()) {
			
			Driver d = opt.get();
			
			dDao.delete(opt.get());
			
			return d;
			
		}else {
			throw new DriverException("Driver not found with this Driver id" + driverId);
		}
	}
	

	@Override
	public List<Driver> viewBestDrivers() throws DriverException {
		
		List<Driver> bdriver = dDao.getTheBestDrivers();
		
		if(bdriver.size() == 0) {
			throw new DriverException("Best Driver not found with rating > 4.5");
		}
		
		return bdriver;
		
	}

	@Override
	public Driver viewDrivers(Integer driverId) throws DriverException {
	
		Optional<Driver> opt = dDao.findById(driverId);
		
		if(opt.isEmpty()) 
			throw new DriverException("Driver not found..");
		
		return opt.get();
	}

}
