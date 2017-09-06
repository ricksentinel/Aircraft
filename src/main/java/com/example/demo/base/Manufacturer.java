package com.example.demo.base;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Manufacturers")
public class Manufacturer {
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Manufacturer_ID")
	private int id;
	
	private String username;
	
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull
	@Size(min=2)
	/*@Column(name = "Manufacturer_NAME")*/
	private String name;
	
	@NotNull
	private String headquarters;
	@ManyToOne
	@JoinColumn(name = "location")
	private Country location;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "aircraft")
	private Collection<Aircraft> aircraft;
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public Manufacturer(String name, String headquarters, Country location) {
		super();
		this.name = name;
		this.headquarters = headquarters;
		this.location = location;
	}
	
	public Manufacturer() {

	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getHeadquarters() {
		return headquarters;
	}
	
	public Country getLocation() {
		return location;
	}
	

	
	
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




	public void setName(String name) {
		this.name = name;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public void setLocation(Country location) {
		this.location = location;
	}


	
	
	
	
	
}
