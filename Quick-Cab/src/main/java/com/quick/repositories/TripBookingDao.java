package com.quick.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quick.exceptions.AdminException;
import com.quick.exceptions.CustomerException;
import com.quick.exceptions.DriverException;
import com.quick.exceptions.TripBookingException;
import com.quick.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer> {

	@Query("select t from TripBooking t where t.customer.customerId=?1")
     public List<TripBooking> getTripsDateWise(Integer cxId) throws TripBookingException;
	
	@Query("select t from TripBooking t where t.customer.customerId=?1")
	public List<TripBooking> getTripsByCustomerID(Integer cxId) throws TripBookingException; 
	
	@Query("select t from TripBooking t where t.driver.driverId=?1")
	 public List<TripBooking> getTripsByDriverId(Integer driverId) throws TripBookingException;
	
	@Query("select t from TripBooking t where t.customer.customerId=?1 AND t.fromDate=?2")
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate)throws TripBookingException;
	
	@Query("select t.bill from TripBooking t where t.customer.customerId=?1")
	public TripBooking calculateBill(Integer customerId) throws TripBookingException;
	
	
	
	
}
