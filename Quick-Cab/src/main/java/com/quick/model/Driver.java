package com.quick.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	@NotNull
	private String licenceNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@NotNull
	private float rating;
	
	@ElementCollection(fetch =FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
	List<TripBooking> tripList = new ArrayList<>();

}
