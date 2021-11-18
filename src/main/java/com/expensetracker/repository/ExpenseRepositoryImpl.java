package com.expensetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public class ExpenseRepositoryImpl implements IExpenseRepository {
	static Connection connection;

	@Override
	public void addTransaction(Expense expense) {

		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.ADDTRANSACTIONQUERY);
			statement.setInt(1, expense.getId());
			statement.setString(2, expense.getType());
			statement.setString(3, expense.getCategory());
			statement.setString(4, expense.getModeOfTransaction());
			statement.setDouble(5, expense.getAmount());
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ModelDAO.closeConnection();
			}

		}

	}

	@Override
	public void updateTransaction(Expense expense) {

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
