package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.base.Manufacturer;
import com.example.demo.repositories.ManufacturerRepository;

public class ManufacturerController {
/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	private ManufacturerRepository mr;
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Autowired
	public ManufacturerController(ManufacturerRepository ar) {
		this.mr = mr;
	}
	
	/*~~~~~~~~~~~~~~END~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~GetMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@GetMapping("/manufacturers/new")
    public String manufacturerForm(Model model) {
        model.addAttribute("newManufacturer", new Manufacturer());
        return "addmanufacturer";
    }
	
	/*~~~~~~~~~~~~~~~~~~~~~~~RequestMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@RequestMapping("/manufacturers/list/all")
	public String listAllManufacturers(Model model){
		model.addAttribute("aircrafts",mr.findAll());
		return "list_aircrafts";
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~PostMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@PostMapping("/manufacturers/new")
	public String manufacturerSignUp(@ModelAttribute Manufacturer newManufacturer, Model model) {
		Manufacturer newCraft = mr.save(newManufacturer);
		return "redirect:/home";
	}
}
