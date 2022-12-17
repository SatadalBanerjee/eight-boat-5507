package com.quick.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quick.exceptions.TripBookingException;
import com.quick.model.TripBooking;
import com.quick.service.TripBookingService;


@RestController
public class TripBookingController {
	
	TripBookingService tripserv;
	
	@PostMapping("/posttrip")
    public ResponseEntity<TripBooking> insertTrip(@RequestParam TripBooking trip) {
    	
    	return new ResponseEntity<TripBooking>(tripserv.insertTrip(trip),HttpStatus.CREATED);
    	
    	
    }
    
	@PutMapping("/puttrip")
    public ResponseEntity<TripBooking> updateTripBooking(@RequestParam TripBooking tripBooking) throws TripBookingException
    {
    	
    	return new ResponseEntity<TripBooking>(tripserv.updateTripBooking(tripBooking),HttpStatus.OK);
    	
    }
	
	@DeleteMapping("/deletetrip/{id}")
    public ResponseEntity<TripBooking> deleteTripBooking(@PathVariable ("id") Integer tripBookingId) throws TripBookingException
    {
    	
    	return new ResponseEntity<TripBooking>(tripserv.deleteTripBooking(tripBookingId),HttpStatus.OK);
    }
	
	@GetMapping("/viewtrip/{id}")
    public ResponseEntity<List<TripBooking>> ViewAllTripsCustomer(@PathVariable ("id") Integer customerId) throws TripBookingException
    {
    	
    	return new ResponseEntity<List<TripBooking>>(tripserv.ViewAllTripsCustomer(customerId),HttpStatus.OK);
    }
	
	@GetMapping("/calculatetrip/{id}")
	public ResponseEntity<TripBooking> CalculateBill(@PathVariable Integer customerId) throws TripBookingException
	{
		return new ResponseEntity<TripBooking>(tripserv.CalculateBill(customerId),HttpStatus.OK);
	}
	
}
