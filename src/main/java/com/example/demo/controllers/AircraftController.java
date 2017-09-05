package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.base.*;
import com.example.demo.repositories.*;


@Controller
public class AircraftController {
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	private AircraftRepository ar;
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Autowired
	public AircraftController(AircraftRepository ar) {
		this.ar = ar;
	}
	
	/*~~~~~~~~~~~~~~END~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~GetMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@GetMapping("/aircrafts/projects/new")
    public String produtoForm(Model model) {
        model.addAttribute("newAircraft", new Aircraft());
        return "addproject";
    }
	
	/*~~~~~~~~~~~~~~~~~~~~~~~RequestMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@RequestMapping("/aircrafts/list/all")
	public String listAllAircrafts(Model model){
		model.addAttribute("aircrafts",ar.findAll());
		return "list_aircrafts";
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~PostMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@PostMapping("/aircrafts/projects/new")
	public String produtoCadastro(@ModelAttribute Aircraft newAircraft, Model model) {
		Aircraft newCraft = ar.save(newAircraft);
		return "redirect:/aircrafts/list/all";
	}
	
}
