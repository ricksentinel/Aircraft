package com.example.demo;

/**
 * Thrown when user attempted to register an already existing username.
 * @author Renan Jesus
 */
public class ExistingUsernameException extends Exception {

	private static final long serialVersionUID = 1819191370095271326L;

	/**
	 * Constructs ExistingUsernameException with error message.
	 */
	public ExistingUsernameException() {
		super("Username is unavailable.");
	}

}
