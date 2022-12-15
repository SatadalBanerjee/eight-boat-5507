package com.quick.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.AdminException;
import com.quick.model.Admin;
import com.quick.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CabService cabService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private TripBookingService bookingService;
	
	 
	@PostMapping("/registeradmin")
	public ResponseEntity<Admin> regAdminHandler (@Valid @RequestBody Admin adm) throws AdminException{
		
		Admin admin= adminService.registerAdmin(adm);
		
		 return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateadmin")
	public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin adm) throws AdminException{
		
		Admin updateadmin = adminService.updateAdmin(adm);
		
		return new ResponseEntity <Admin>(updateadmin,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<Admin> deleteAdminByIdHandler( @PathVariable Integer id) throws AdminException{
		
		Admin deleteadmin = adminService.deleteAdmin(id);
		
		return new ResponseEntity <Admin>(deleteadmin,HttpStatus.OK);
	}
	
	

	@GetMapping("/getalltrips")
	public ResponseEntity<List<TripBooking>> getAllTripsHandler() throws AdminException{
		
		List<TripBooking> list = adminService.getAllTrips();
		
		return new ResponseEntity<List<TripBooking>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/driverTrips/{driverId}")
	public ResponseEntity<List<TripBooking>> getAllTripByDriverIDHandler(@PathVariable ("driverId") Integer id) throws AdminException{
		
		List<TripBooking> list = adminService.getTripsByDriverId(id);
		
		return new ResponseEntity<List<TripBooking>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/driverTrips/{customerId}")
	public ResponseEntity<List<TripBooking>> getTripsByCustomerIDHandler(@PathVariable ("customerId") Integer id) throws AdminException{
		
		List<TripBooking> list = adminService.getTripsByCustomerID(id);
		
		return new ResponseEntity<List<TripBooking>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/driverTrips/{customerId}")
	public ResponseEntity<List<TripBooking>> getTripsDateWiseHandler(@PathVariable ("customerId") Integer id) throws AdminException{
		
		List<TripBooking> list = adminService.getTripsDateWise();
		
		return new ResponseEntity<List<TripBooking>>(list,HttpStatus.OK);
	}
}
