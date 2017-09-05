package com.example.demo.base;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Forces")
public class AirForce {
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=2)
	private String name;
	
	@NotNull
	@OneToOne
	private Country affiliation;
	
	@ManyToMany
	private Collection<Aircraft> aircraftsUsed;

	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public AirForce(String name, Country affiliation) {
		super();
		this.name = name;
		this.affiliation = affiliation;
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Country getAffiliation() {
		return affiliation;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	public void setName(String name) {
		this.name = name;
	}

	public void setAffiliation(Country affiliation) {
		this.affiliation = affiliation;
	}

	
	
	
}
