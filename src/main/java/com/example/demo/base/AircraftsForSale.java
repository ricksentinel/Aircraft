package com.example.demo.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AircraftsForSale {

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private Aircraft aircraft;
	
	@NotNull
	@Min(0)
	private double price; //in Million USD
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	public int getId() {
		return id;
	}
	
	public Aircraft getAircraft() {
		return aircraft;
	}
	
	public double getPrice() {
		return price;
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}
