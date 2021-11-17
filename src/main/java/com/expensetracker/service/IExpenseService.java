package com.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.model.Expense;

public interface IExpenseService {
	void addTransaction(Expense expense);

	void deleteTransaction(int transaction);

	void updateTransaction(Expense expense);

	List<Expense> getTransactionById(int transaction) throws ExpenseRecordNotFoundException;

	List<Expense> getTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException;

}
