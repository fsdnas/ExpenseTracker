package com.expensetracker.repository;


import java.time.LocalDate;

import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public interface IExpenseRepository {

	void addTransaction(Expense expense);
	void deleteTransaction(int  transactionId) throws ExpenseRecordNotFoundException;
	void updateTransaction(int transactionId) throws ExpenseRecordNotFoundException;

	List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException;

	List<Expense> findTrnasactionByDate(LocalDate date) throws ExpenseRecordNotFoundException;

	List<Expense> findTransactionByUser(User user)throws UserNotFoundException;

	List<Expense> findAllTransaction();

}
