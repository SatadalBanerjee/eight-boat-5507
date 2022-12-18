package com.quick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.exceptions.TripBookingException;
import com.quick.model.TripBooking;
import com.quick.repositories.TripBookingDao;
@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	TripBookingDao tripDao;

	@Override
	public TripBooking insertTrip(TripBooking trip) throws TripBookingException {
		// TODO Auto-generated method stub
		
		if(trip!=null)
		{
			TripBooking tri=tripDao.save(trip);
			return  tri;
		}
		else
		{
			throw new TripBookingException("Please enter valid TripBooking details");
		}
		
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException{
		// TODO Auto-generated method stub
		Optional<TripBooking> opt=tripDao.findById(tripBooking.getTripbookingId());
		if(opt.isPresent())
		{
			tripDao.save(tripBooking);
			return opt.get();
		}
		else
		{
			throw new TripBookingException("TripBooking Id is not exist");
		}
		
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException {
		// TODO Auto-generated method stub
		Optional<TripBooking> opt=tripDao.findById(tripBookingId);
		if(opt.isPresent())
		{
			tripDao.delete(opt.get());
			return opt.get();
		}
		else
		{
			throw new TripBookingException("TripBooking Id is not exist");
		}
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(Integer customerId) throws TripBookingException {
		// TODO Auto-generated method stub
		Optional<TripBooking> opt=tripDao.findById(customerId);
		if(opt.isPresent())
		{
			
			List<TripBooking> list=tripDao.getTripsByCustomerID(customerId);
			return list;
		}
		else
		{
			throw new TripBookingException("Customer with this Id does not exist");
		}
		
	}

	@Override
	public TripBooking CalculateBill(Integer customerId) throws TripBookingException {
		// TODO Auto-generated method stub
		TripBooking book=tripDao.calculateBill(customerId);
		if(book!=null)
		{
			
			return book;
		}
		else
		{
			throw new TripBookingException("Customer with this Id does not exist");
		}
	}
	
	
}
