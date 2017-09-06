package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.base.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer>{

	Manufacturer findByName(String name);
	
}
