package com.quick.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.DriverException;
import com.quick.model.Driver;
import com.quick.service.DriverService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DriverController {

	@Autowired	
	private DriverService dService;

	@PostMapping("/driverInsert")
	public ResponseEntity<Driver> insertDriverHandler(Driver driver) throws DriverException {

		Driver insertD = dService.insertDriver(driver);

		return new ResponseEntity<Driver>(insertD, HttpStatus.CREATED);
	}

	@PutMapping("/driverUpdate")
	public ResponseEntity<Driver> updateDriverHandler(@RequestBody Driver driver) throws DriverException {

		Driver updateD = dService.updateDriver(driver);

		return new ResponseEntity<Driver>(updateD, HttpStatus.OK);

	}

	@DeleteMapping("/driverDelete/{id}")
	public ResponseEntity<Driver> deleteDriverHandler(@PathVariable("id") Integer driverId) throws DriverException {

		Driver deleteD = dService.deleteDriver(driverId);

		return new ResponseEntity<Driver>(deleteD, HttpStatus.OK);

	}

	@GetMapping("/driverBest")
	public ResponseEntity<List<Driver>> viewBestDriversHandler() throws DriverException {

		List<Driver> bestD = dService.viewBestDrivers();

		return new ResponseEntity<List<Driver>>(bestD, HttpStatus.OK);

	}

	@GetMapping("/driverView{id}")
	public ResponseEntity<Driver> viewDriversHandler(@PathVariable("id") Integer driverId) throws DriverException {

		Driver viewD = dService.viewDrivers(driverId);

		return new ResponseEntity<Driver>(viewD, HttpStatus.OK);

	}

}
