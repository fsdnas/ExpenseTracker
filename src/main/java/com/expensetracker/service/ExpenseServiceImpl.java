/**
 * 
 * @author Nayeem & SahabJaiswal
 * @version 1.0
 */

package com.expensetracker.service;

import java.time.LocalDate;

import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;

import com.expensetracker.repository.ExpenseRepositoryImpl;
import com.expensetracker.repository.IExpenseRepository;

public class ExpenseServiceImpl implements IExpenseService {
	IExpenseRepository expenseRepository = new ExpenseRepositoryImpl();

	/**
	 * @param expense
	 */
	@Override
	public void addTransaction(Expense expense) {
		expenseRepository.addTransaction(expense);

	}

	/**
	 * @param transactionId
	 */
	@Override
	public void deleteTransaction(int transactionId) {
		try {
			expenseRepository.deleteTransaction(transactionId);
		} catch (ExpenseRecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param transactionId
	 */
	@Override
	public void updateTransaction(Expense expense) {
		try {
			expenseRepository.updateTransaction(expense);
		} catch (ExpenseRecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param transactionId
	 * @return
	 */
	@Override
	public List<Expense> getTransactionById(int transactionId) throws ExpenseRecordNotFoundException {
		return expenseRepository.findTransactionById(transactionId);
	}

	/**
	 * @param date
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> getTransactionByDate(LocalDate date, int userId) throws ExpenseRecordNotFoundException {
		return expenseRepository.findTransactionByDate(date, userId);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> findTransactionByUser(int userId) throws UserNotFoundException {
		return expenseRepository.findTransactionByUser(userId);
	}

	/**
	 * 
	 */
	@Override
	public List<Expense> findAllTransaction() {
		return expenseRepository.findAllTransaction();
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> getStatsByCategory(int userId) throws UserNotFoundException {

		return expenseRepository.getStatsByCategory(userId);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> getStatsByModeOfTransaction(int userId) throws UserNotFoundException {

		return expenseRepository.getStatsByModeOfTransaction(userId);
	}

}
