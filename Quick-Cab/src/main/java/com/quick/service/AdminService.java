package com.quick.service;


import java.time.LocalDateTime;

import java.util.List;

import com.quick.exceptions.AdminException;
import com.quick.exceptions.TripBookingException;
import com.quick.model.Admin;
import com.quick.model.TripBooking;


public interface AdminService {
	

	public Admin registerAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public List<TripBooking> getAllTrips() throws AdminException;
	
	public List<TripBooking> getTripsByDriverId(Integer id) throws AdminException,TripBookingException;
	
	public List<TripBooking> getTripsByCustomerID(Integer cxId) throws AdminException,TripBookingException;

	public List<TripBooking> getTripsDateWise(Integer cxId) throws AdminException,TripBookingException,TripBookingException;
	
	public List<TripBooking> getAllTripsForDays(Integer customerId,LocalDateTime fromDate,LocalDateTime toDate)throws AdminException,TripBookingException;
	
	
	
}

