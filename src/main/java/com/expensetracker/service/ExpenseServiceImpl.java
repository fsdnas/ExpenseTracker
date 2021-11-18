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
		return null;
	}

	@Override
	public List<Expense> getTransactionByDate(LocalDate date) throws ExpenseRecordNotFoundException {
		return expenseRepository.findTransactionByDate(date);
	}

	@Override
	public List<Expense> findTransactionByUser(int userId) throws UserNotFoundException {
		return expenseRepository.findTransactionByUser(userId);
	}

	@Override
	public List<Expense> findAllTransaction() {
		return expenseRepository.findAllTransaction();
	}

	@Override
	public List<Expense> getStatsByCategory(int userId) throws UserNotFoundException {
		
		return null;
	}

	@Override
	public List<Expense> getStatsByModeOfTransaction(int userId) throws UserNotFoundException {
		
		return null;
	}

}
