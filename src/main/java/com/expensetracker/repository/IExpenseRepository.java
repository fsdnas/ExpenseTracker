package com.expensetracker.repository;

import java.time.LocalDate;

import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;

public interface IExpenseRepository {

	void addTransaction(Expense expense);

	void deleteTransaction(int transactionId) throws ExpenseRecordNotFoundException;

	void updateTransaction(int transactionId) throws ExpenseRecordNotFoundException;

	List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException;

	List<Expense> findTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException;

	List<Expense> findTransactionByUser(int userId) throws UserNotFoundException;

	List<Expense> findAllTransaction();

}
