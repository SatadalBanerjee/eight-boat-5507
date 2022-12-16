package com.quick.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabid;

	@NotNull
	private String carType;

	@NotNull
	private Double perKmRate;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cab")
	private Driver driver;

	public Cab(Integer cabid, @NotNull String carType, @NotNull Double perKmRate, Driver driver) {
		super();
		this.cabid = cabid;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.driver = driver;
	}

	public Cab() {
		super();
	}

	public Cab(@NotNull String carType, @NotNull Double perKmRate, Driver driver) {
		super();
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.driver = driver;
	}

	public Integer getCabid() {
		return cabid;
	}

	public void setCabid(Integer cabid) {
		this.cabid = cabid;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Double getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Double perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Cab [cabid=" + cabid + ", carType=" + carType + ", perKmRate=" + perKmRate + ", driver=" + driver + "]";
	}

}
