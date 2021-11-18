package com.expensetracker.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.model.Expense;

public interface IExpenseService {
	void addTransaction(Expense expense);

	void deleteTransaction(int transactionId);

	void updateTransaction(int transactionId);

	List<Expense> getTransactionById(int transaction) throws ExpenseRecordNotFoundException;

	List<Expense> getTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException;

}
