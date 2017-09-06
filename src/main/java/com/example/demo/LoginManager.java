package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.base.Manufacturer;
import com.example.demo.repositories.ManufacturerRepository;

/**
 * Manages users' authentication.
 * @author Renan Jesus
 */
@Component
public class LoginManager implements AuthenticationManager {

	private static ManufacturerRepository allUsers;
	private static final List<GrantedAuthority> authorities = new ArrayList<>();
	
	/**
	 * Constructs LoginManager initializing empty UserRepository and list of
	 * authorities.
	 * @param repository Repository of users' information.
	 */
	@Autowired
	public LoginManager(ManufacturerRepository repository) {
		LoginManager.allUsers = repository;

		// Add all authorities.
		LoginManager.authorities.add(new SimpleGrantedAuthority("USER"));
		LoginManager.authorities.add(new SimpleGrantedAuthority("ADMIN"));
	}

	/**
	 * Authenticates user.
	 * @param login User's login information (e.g. username and password).
	 * @return Authenticated token.
	 * @throws BadCredentialsException
	 */
	@Override
	public Authentication authenticate(Authentication login) throws BadCredentialsException {
		// Find user by its username.
		Manufacturer user = allUsers.findByName(login.getName());
		
		// If credentials match with database, return authenticated token.
		if ((user != null) && login.getCredentials().equals(user.getPassword())) {
			List<GrantedAuthority> auth = new ArrayList<>();
			auth.add(new SimpleGrantedAuthority("ADMIN"));
			
			return new UsernamePasswordAuthenticationToken(	user.getUsername(), user.getPassword(),
															auth);
		}

		// Otherwise, throw exception of invalid credentials.
		throw new BadCredentialsException("Invalid username or password.");
	}

	/**
	 * Register new user in database.
	 * @param user User's information.
	 * @throws ExistingUsernameException
	 */
	public void registerUser(Manufacturer user) throws ExistingUsernameException {
		// Assert that username is unique.
		if (!LoginManager.allUsers.exists(user.getId())) {
			LoginManager.allUsers.save(user);
		}

		else {
			// Otherwise, username already exists, throw exception.
			throw new ExistingUsernameException();
		}
	}
	
	/**
	 * @return Repository of users' information.
	 */
	public static ManufacturerRepository getUserRepository() {
		return LoginManager.allUsers;
	}

}
