package com.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.model.Expense;

public class ExpenseServiceImpl implements IExpenseService {

	@Override
	public void addTransaction(Expense expense) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTransaction(int transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTransaction(Expense expense) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Expense> getTransactionById(int transaction) throws ExpenseRecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> getTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
