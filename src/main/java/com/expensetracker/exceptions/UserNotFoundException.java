package com.expensetracker.exceptions;

/**
 * 
 * @author SahabJaiswal
 * @version 1.0
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
