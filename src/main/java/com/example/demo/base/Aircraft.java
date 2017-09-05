package com.example.demo.base;


import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Aircrafts")
public class Aircraft {
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=2)
	private String model;
	
	@NotNull
	@Size(min=2)
	private String name;

	/*@ManyToOne
	@JoinColumn(name = "Manufacturer_NAME")
	private Manufacturer manufacturer;*/
	
	String manufacturer;
	
	@ManyToMany
	private Collection<AirForce> users;
	
	
	String aircraftClass;//Helicopters, Jets, Bombers, Drones, etc.
	
	double wingspan; //in meters
	double topSpeed; //in Km/h
	double height; //in meters
	double length; //in meters
	
	/*~~~~~~~~~~~~~~~~~~~~~~END~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public Aircraft(String model, String name) {
		super();
		this.model = model;
		this.name = name;
	}
	
	public Aircraft() {
		
	}
	
	/*~~~~~~~~~~~~~~END~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public int getId() {
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAircraftClass() {
		return aircraftClass;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~END~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAircraftClass(String aircraftClass) {
		this.aircraftClass = aircraftClass;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~END~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}
