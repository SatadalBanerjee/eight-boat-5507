package com.quick.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripbookingId;

	@NotNull
	private String fromLocation;
	@NotNull
	private String toLocation;
	private LocalDate fromDate;
	private LocalDate toDate;

	@NotNull
	private boolean status;
	@NotNull
	private Double distanceInKm;
	@NotNull
	private Double bill;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Driver driver;
	
	public  TripBooking()
	{
		
	}

	public TripBooking( String fromLocation, String toLocation, LocalDate fromDate,
			LocalDate toDate, boolean status, Double distanceInKm, Double bill, Customer customer, Driver driver) {
		super();
		
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.customer = customer;
		this.driver = driver;
	}
	
	

	public TripBooking(Integer tripbookingId, String fromLocation, String toLocation, LocalDate fromDate,
			LocalDate toDate, boolean status, Double distanceInKm, Double bill, Customer customer, Driver driver) {
		super();
		this.tripbookingId = tripbookingId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.customer = customer;
		this.driver = driver;
	}

	
	
	

}
