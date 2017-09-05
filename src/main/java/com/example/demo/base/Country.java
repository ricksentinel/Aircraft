package com.example.demo.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Countries")
public class Country {
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	int id;
	
	@NotNull
	@Size(min=2)
	String name;
	
	@NotNull
	@Size(min=2)
	String continent;
	
	
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public Country(String name, String continent) {
		super();
		this.name = name;
		this.continent = continent;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public String getName() {
		return name;
	}
	
	public String getContinent() {
		return continent;
	}
}
