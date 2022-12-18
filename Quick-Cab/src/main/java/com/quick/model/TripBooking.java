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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	
	

	
	
	

}
