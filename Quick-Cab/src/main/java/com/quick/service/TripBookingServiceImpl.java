package com.quick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.model.TripBooking;
import com.quick.repositories.TripBookingDao;
@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	TripBookingDao tripDao;
	
	@Override
	public TripBooking newTrip(TripBooking trip) {
		
		return tripDao.save(trip);

	}
}
