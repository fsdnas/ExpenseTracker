/**
 * 
 * @author SahabJaiswal
 * @version 1.0
 */

package com.expensetracker.exceptions;

public class ExpenseRecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExpenseRecordNotFoundException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public ExpenseRecordNotFoundException(String message) {
		super(message);
	}

}
