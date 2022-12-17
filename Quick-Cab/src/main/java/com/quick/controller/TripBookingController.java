package com.quick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.quick.service.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tbService;
	
	
	
}
