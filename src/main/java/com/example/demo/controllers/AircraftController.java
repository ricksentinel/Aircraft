package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ExistingUsernameException;
import com.example.demo.LoginManager;
import com.example.demo.base.*;
import com.example.demo.repositories.*;


@Controller
public class AircraftController {
	
	private static AuthenticationManager loginManager;
	
	/**
	 * Displays form to register new user: GET mapping.
	 * @return View "register".
	 */
	@GetMapping("/register")
	public String registerNewUser() {
		return "register";
	}
	
	/**
	 * Registers new user as long as username is available: POST mapping.
	 * @param username User's login name.
	 * @param password User's password.
	 * @return View "login".
	 * @throws ExistingUsernameException 
	 */
	@PostMapping("/register")
	public String registerPost(	@RequestParam("username") String username,
								@RequestParam("realName") String realName,
								@RequestParam("password") String password,
								@RequestParam("headquarters") String headquarters) throws ExistingUsernameException {
		// Register new user as long as its username is available.
		Manufacturer newUser = new Manufacturer();
		newUser.setUsername(username);
		newUser.setName(realName);
		newUser.setPassword(password);
		newUser.setHeadquarters(headquarters);

		((LoginManager) loginManager).registerUser(newUser);

		return "redirect:/login";
	}
	
	/**
	 * Displays form to authenticate user: GET mapping.
	 * @return View "login".
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * Allows user to access restricted pages if credentials are correct: POST
	 * mapping.
	 * @param username User's login name.
	 * @param password User's password.
	 * @return View "home".
	 */
	@PostMapping("/login")
	public String login(@RequestParam(name = "username") String username,
						@RequestParam(name = "password") String password,
						Model model) {
		try {
			// Attempt to authenticate user using its token.
			SecurityContextHolder
				.getContext()
				.setAuthentication(
				    AircraftController
				        .loginManager
						.authenticate(
						    new UsernamePasswordAuthenticationToken(username,password)
								  ));
		} catch (BadCredentialsException e) {
			return "redirect:/login";
		}

		return "home";
	}
	
	
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~Attributes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	private AircraftRepository ar;
	
	/*~~~~~~~~~~~~~~~~~~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@Autowired
	public AircraftController(AircraftRepository ar, LoginManager lm) {
		this.ar = ar;
		loginManager = lm;
	}
	
	/*~~~~~~~~~~~~~~END~Constructors/Initializers~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~GetMapping~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	@GetMapping("/aircrafts/projects/new")
    public String aircraftForm(Model model) {
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
	public String registerAircraft(@ModelAttribute Aircraft newAircraft, Model model) {
		Aircraft newCraft = ar.save(newAircraft);
		return "redirect:/aircrafts/list/all";
	}
	
}
