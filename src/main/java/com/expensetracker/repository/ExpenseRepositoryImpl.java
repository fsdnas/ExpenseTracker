package com.expensetracker.repository;

import java.time.LocalDate;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public class ExpenseRepositoryImpl implements IExpenseRepository {

	@Override
	public void addTransaction(Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTransaction(Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findTrnasactionByDate(LocalDate date) throws ExpenseRecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findTransactionByUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
