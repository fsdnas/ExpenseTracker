package com.expensetracker.exceptions;

/**
 * 
 * @author SahabJaiswal
 * @version 1.0
 */
public class ExpenseRecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExpenseRecordNotFoundException() {
		super();
	}

	public ExpenseRecordNotFoundException(String message) {
		super(message);
	}

}
