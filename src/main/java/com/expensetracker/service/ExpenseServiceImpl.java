package com.expensetracker.service;

import java.time.LocalDate;

import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepositoryImpl;
import com.expensetracker.repository.IExpenseRepository;

public class ExpenseServiceImpl implements IExpenseService {
	IExpenseRepository expenseRepository = new ExpenseRepositoryImpl();
	
	@Override
	public void addTransaction(Expense expense) {
		expenseRepository.addTransaction(expense);

	}

	@Override
	public void deleteTransaction(int transaction) {
		try {
			expenseRepository.deleteTransaction(transaction);
		} catch (ExpenseRecordNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateTransaction(int transactionId) {
		try {
			expenseRepository.updateTransaction(transactionId);
		} catch (ExpenseRecordNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Expense> getTransactionById(int transaction) throws ExpenseRecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> getTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException {
		
		return expenseRepository.findTrnasactionByDate(date);
	}

	

}
