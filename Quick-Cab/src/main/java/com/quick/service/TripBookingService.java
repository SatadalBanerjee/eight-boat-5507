package com.quick.service;

import java.util.List;

import com.quick.exceptions.TripBookingException;
import com.quick.model.TripBooking;

public interface TripBookingService {
	
	public TripBooking insertTrip(TripBooking trip) ;
	
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException;
	
	public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException;
	
	public List<TripBooking> ViewAllTripsCustomer(Integer customerId) throws TripBookingException;
	
	public TripBooking CalculateBill(Integer customerId) throws TripBookingException;
}
