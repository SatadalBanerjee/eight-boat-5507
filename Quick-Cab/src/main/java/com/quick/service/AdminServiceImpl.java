package com.quick.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.DTO.*;
import com.quick.exceptions.*;
import com.quick.model.*;
import com.quick.repositories.*;

@Service
public class AdminServiceImpl implements AdminService{

	
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	public TripBookingDao tripBookingDao;
	
	@Autowired
	public CustomerDao customerDao;

	@Autowired
	public DriverDao driverDao;
	
	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		
		if(admin != null) {
			Admin savedAdmin = adminDao.save(admin);
			return savedAdmin;
			
		}else {
			throw new AdminException("Please enter valid admin details");
			
		}
		
	}

	
	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		
		Optional<Admin> opt = adminDao.findById(admin.getAdminId());
		
		if(opt.isPresent()) {
			
			Admin updatedDetails = adminDao.save(admin);
			
			return updatedDetails;
			
		}else {
			
			throw new AdminException("Admin details are invalid");
		}
	}

	
	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> opt = adminDao.findById(adminId);
		
		if(opt.isPresent()) {
			
			Admin ad=opt.get();
			
			adminDao.delete(ad);
			
			return opt.get();
		}else {
			
			throw new AdminException("Please enter valid admin id");
		}
	}

	
	@Override
	public List<TripBooking> getAllTrips() throws AdminException {
		// TODO Auto-generated method stub
		
		List<TripBooking> li = tripBookingDao.findAll();
		
		if(li.size()== 0) {
			
			return li;
		}
		else {
			throw new AdminException("Trip List is empty");
		}
	}

	
	
	
	@Override
	public List<TripBooking> getTripsByDriverId(Integer driverId) throws AdminException {
		// TODO Auto-generated method stub
		
		Optional<Driver> opt = driverDao.findById(driverId);
		
		if(opt.get().getTripList().size() == 0) {
			
			return opt.get().getTripList();
		}
		else {
			throw new AdminException("Please check the entered driver Id");
		}

	}

	
	@Override
	public List<TripBooking> getTripsByCustomerID(Integer cxId) throws AdminException {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt = customerDao.findById(cxId);
		
		if(opt.get().getTripList().size() == 0) {
			
			return opt.get().getTripList();
		}
		else {
			throw new AdminException("Please check the entered customer Id");
		}
	}


	@Override
	public List<TripBooking> getTripsDateWise() throws AdminException {
		
		List<TripBooking> dateWiseList = tripBookingDao.getAllTrips();
		
		if(!dateWiseList.isEmpty()) {
			
			return dateWiseList;
			
		}else {
			
			throw new AdminException("There are no trips on this day");
		}
	}


	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate) throws AdminException {
	
		
		List<TripBooking> listFromTo = tripBookingDao.getAllTripBetweenDate(customerId,fromDate,toDate);
		
		if(!listFromTo.isEmpty()) {
			
			return listFromTo;
			
		}
		else {
			throw new AdminException("There are no trip between these two dates");
		}
	}


}
