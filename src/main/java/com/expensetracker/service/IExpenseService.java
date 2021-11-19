/**
 * 
 * @author SahabJaiswal
 *
 */

package com.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;

public interface IExpenseService {
	/**
	 * 
	 * @param expense
	 */
	void addTransaction(Expense expense);

	/**
	 * 
	 * @param transactionId
	 */
	void deleteTransaction(int transactionId);

	/**
	 * 
	 * @param transactionId
	 */
	void updateTransaction(int transactionId);

	/**
	 * 
	 * @param transaction
	 * @return
	 * @throws ExpenseRecordNotFoundException
	 */
	List<Expense> getTransactionById(int transaction) throws ExpenseRecordNotFoundException;

	/**
	 * 
	 * @param date
	 * @param userId
	 * @return
	 * @throws ExpenseRecordNotFoundException
	 */
	List<Expense> getTransactionByDate(LocalDate date, int userId) throws ExpenseRecordNotFoundException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	List<Expense> findTransactionByUser(int userId) throws UserNotFoundException;

	/**
	 * 
	 * @return
	 */
	List<Expense> findAllTransaction();

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	List<Expense> getStatsByCategory(int userId) throws UserNotFoundException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	List<Expense> getStatsByModeOfTransaction(int userId) throws UserNotFoundException;
}
