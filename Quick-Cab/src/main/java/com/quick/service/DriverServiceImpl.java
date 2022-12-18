package com.quick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.DriverException;
import com.quick.model.Cab;
import com.quick.model.Driver;
import com.quick.repositories.CabDao;
import com.quick.repositories.DriverDao;

import io.swagger.v3.oas.annotations.servers.Server;


@Service 

public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao dDao;

	@Autowired
	private CabDao cDao;

	
	@Override
	public Driver insertDriver(Driver driver) throws DriverException {

		List<Cab> cabList = cDao.findAll();

		if (cabList.size() == 0) {
			throw new DriverException("No cab found..");
		}

		for (Cab c : cabList) {

			if (c.isStatus() == false){

				c.setStatus(true);
				driver.setCab(c);
				c.setDriver(driver);
				break;
			}

		}

		if (driver.getCab() == null)
			throw new DriverException("No Cab Left For Driver..!");
		Driver d = dDao.save(driver);
		if (d == null)
			throw new DriverException("Please Fill Proper Details..!");

		return d;

	}
	
	

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {

		Optional<Driver> opt = dDao.findById(driver.getDriverId());

		if (opt.isPresent()) {

			Driver upDriver = dDao.save(driver);

			upDriver.setCab(opt.get().getCab());

			return upDriver;

		} else {
			throw new DriverException("Driver details not update");
		}

	}
	

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {

		Optional<Driver> opt = dDao.findById(driverId);

		if (opt.isPresent()) {

			Driver d = opt.get();

			d.getCab().setStatus(false);

			dDao.delete(opt.get());

			return d;

		} else {
			throw new DriverException("Driver not found with this Driver id" + driverId);
		}
	}

	
	@Override
	public List<Driver> viewBestDrivers() throws DriverException {

		List<Driver> bdriver = dDao.getTheBestDrivers();

		if (bdriver.size() == 0) {
			throw new DriverException("Best Driver not found with rating > 4.5");
		}

		return bdriver;

	}

	
	@Override
	public Driver viewDrivers(Integer driverId) throws DriverException {

		Optional<Driver> opt = dDao.findById(driverId);

		if (opt.isEmpty())
			throw new DriverException("Driver not found..");

		return opt.get();
	}

}
