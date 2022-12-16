package com.quick.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.masai.model.Customer;
//import com.masai.model.Driver;
//import com.masai.model.TripStatus;

@Entity
public class TripBooking {
	
	@Id
	@SequenceGenerator(name = "trip_generator", sequenceName = "trip_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_generator")
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

	@ManyToOne
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
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

	public Integer gettripbookingId() {
		return tripbookingId;
	}

	public void settripbookingId(Integer tripbookingId) {
		this.tripbookingId = tripbookingId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "TripBooking [tripbookingId=" + tripbookingId + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", fromDate=" + fromDate + ", toDate=" + toDate + ", status=" + status
				+ ", distanceInKm=" + distanceInKm + ", bill=" + bill + ", customer=" + customer + ", driver=" + driver
				+ ", getTripbookingId()=" + gettripbookingId() + ", getFromLocation()=" + getFromLocation()
				+ ", getToLocation()=" + getToLocation() + ", getFromDate()=" + getFromDate() + ", getToDate()="
				+ getToDate() + ", getStatus()=" + getStatus() + ", getDistanceInKm()=" + getDistanceInKm()
				+ ", getBill()=" + getBill() + ", getCustomer()=" + getCustomer() + ", getDriver()=" + getDriver()
				+ "]";
	}
	
	

}
