package com.quick.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabid;

	@NotNull
	private String cabType;

	@NotNull
	private Double perKmRate;
	
	@NotNull
	private boolean  status;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cab")
	private Driver driver;

	

}
