/**
 * 
 * @author SahabJaiswal
 *
 */

package com.expensetracker.repository;

import java.time.LocalDate;

import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;

public interface IExpenseRepository {
	/**
	 * 
	 * @param expense
	 */
	void addTransaction(Expense expense);

	/**
	 * 
	 * @param transactionId
	 * @throws ExpenseRecordNotFoundException
	 */
	void deleteTransaction(int transactionId) throws ExpenseRecordNotFoundException;

	/**
	 * 
	 * @param transactionId
	 * @throws ExpenseRecordNotFoundException
	 */
	void updateTransaction(Expense expense) throws ExpenseRecordNotFoundException;

	/**
	 * 
	 * @param transactionId
	 * @return
	 * @throws ExpenseRecordNotFoundException
	 */
	List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException;

	/**
	 * 
	 * @param date
	 * @param userId
	 * @return
	 * @throws ExpenseRecordNotFoundException
	 */
	List<Expense> findTransactionByDate(LocalDate date, int userId) throws ExpenseRecordNotFoundException;

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
