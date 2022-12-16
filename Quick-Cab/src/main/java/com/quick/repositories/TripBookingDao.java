package com.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quick.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer> {

}
